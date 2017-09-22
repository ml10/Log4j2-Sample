package com.anneliu.plugin;

import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SensitiveInfoEraser {

  private static final Set<Pattern> patternSet = new HashSet<>();
  private static final String PARAMETER_SUFFIX_IN_FEEDBACK = "status=\".*?\">\\s*<value>\\s*<p>(.*?)<\\/p>"
      + "\\s*<\\/value>\\s*<\\/parameter>";
  private static final String PARAMETER_SUFFIX_IN_MO = "definition=Optional"
      + ".*?value=Optional\\[ParameterValue\\{value=(.*?)}]}";

  static {
    patternSet.add(Pattern.compile("preSharedKey\">(.*?)<"));
    patternSet.add(Pattern.compile("refNum\">(.*?)<"));
    patternSet.add(Pattern.compile("password\">(.*?)<"));
    patternSet.add(Pattern.compile("https://(.*)"));
    patternSet.add(Pattern.compile("http://(.*)"));
    patternSet.add(Pattern.compile("dst:(.*)"));
    patternSet.add(Pattern.compile("src:(.*)"));

    patternSet.add(Pattern.compile("serialNumber\">(.*?)<"));
    patternSet.add(Pattern.compile("issuer\">(.*?)<"));
    patternSet.add(Pattern.compile("fingerprint\">(.*?)<"));
    patternSet.add(Pattern.compile("caSubjectName\">(.*?)<"));
    patternSet.add(Pattern.compile("caType\">(.*?)<"));
    patternSet.add(Pattern.compile("serverHost\">(.*?)<"));

    patternSet.add(Pattern.compile("<parameter name=\"preSharedKey\" " + PARAMETER_SUFFIX_IN_FEEDBACK));
    patternSet.add(Pattern.compile("<parameter name=\"refNum\" " + PARAMETER_SUFFIX_IN_FEEDBACK));
    patternSet.add(Pattern.compile("<parameter name=\"caSubjectName\" " + PARAMETER_SUFFIX_IN_FEEDBACK));
    patternSet.add(Pattern.compile("<parameter name=\"serverPort\" " + PARAMETER_SUFFIX_IN_FEEDBACK));
    patternSet.add(Pattern.compile("<parameter name=\"serverHost\" " + PARAMETER_SUFFIX_IN_FEEDBACK));
    patternSet.add(Pattern.compile("<parameter name=\"serialNumber\" " + PARAMETER_SUFFIX_IN_FEEDBACK));
    patternSet.add(Pattern.compile("<parameter name=\"issuer\" " + PARAMETER_SUFFIX_IN_FEEDBACK));
    patternSet.add(Pattern.compile("<parameter name=\"fingerprint\" " + PARAMETER_SUFFIX_IN_FEEDBACK));
    patternSet.add(Pattern.compile("<parameter name=\"asResiliencyIpAddress\" " + PARAMETER_SUFFIX_IN_FEEDBACK));
    patternSet.add(Pattern.compile("<parameter name=\"asResiliencyGateway\" " + PARAMETER_SUFFIX_IN_FEEDBACK));
    patternSet.add(Pattern.compile("<parameter name=\"asResiliencyPeerIpAddress\" " + PARAMETER_SUFFIX_IN_FEEDBACK));
    patternSet.add(Pattern.compile("<parameter name=\"northboundVIpAddress\" " + PARAMETER_SUFFIX_IN_FEEDBACK));
    patternSet.add(Pattern.compile("<parameter name=\"northboundVIpGateway\" " + PARAMETER_SUFFIX_IN_FEEDBACK));
    patternSet.add(Pattern.compile("<parameter name=\"southboundVIpAddress\" " + PARAMETER_SUFFIX_IN_FEEDBACK));
    patternSet.add(Pattern.compile("<parameter name=\"southboundVIpGateway\" " + PARAMETER_SUFFIX_IN_FEEDBACK));
    patternSet.add(Pattern.compile("<parameter name=\"sdlPrimaryDestIp\" " + PARAMETER_SUFFIX_IN_FEEDBACK));
    patternSet.add(Pattern.compile("<parameter name=\"southboundIpAddress\" " + PARAMETER_SUFFIX_IN_FEEDBACK));
    patternSet.add(Pattern.compile("<parameter name=\"southboundGateway\" " + PARAMETER_SUFFIX_IN_FEEDBACK));
    patternSet.add(Pattern.compile("<parameter name=\"northboundIpAddress\" " + PARAMETER_SUFFIX_IN_FEEDBACK));
    patternSet.add(Pattern.compile("<parameter name=\"northboundGateway\" " + PARAMETER_SUFFIX_IN_FEEDBACK));

    patternSet.add(Pattern.compile("-----BEGIN CERTIFICATE-----\\n([\\s\\S]*?)\\n-----END CERTIFICATE-----"));
    patternSet.add(Pattern.compile("name='preSharedKey', " + PARAMETER_SUFFIX_IN_MO));
    patternSet.add(Pattern.compile("name='password', " + PARAMETER_SUFFIX_IN_MO));
    patternSet.add(Pattern.compile("name='refNum', " + PARAMETER_SUFFIX_IN_MO));

    patternSet.add(Pattern.compile("asResiliencyGateway\">(.*?)<"));
    patternSet.add(Pattern.compile("asResiliencyIpAddress\">(.*?)<"));
    patternSet.add(Pattern.compile("asResiliencyPeerIpAddress\">(.*?)<"));
    patternSet.add(Pattern.compile("northboundVIpAddress\">(.*?)<"));
    patternSet.add(Pattern.compile("northboundVIpGateway\">(.*?)<"));
    patternSet.add(Pattern.compile("southboundVIpAddress\">(.*?)<"));
    patternSet.add(Pattern.compile("southboundVIpGateway\">(.*?)<"));
    patternSet.add(Pattern.compile("sdlPrimaryDestIp\">(.*?)<"));

    patternSet.add(Pattern.compile("asResiliencyGateway=(.[^\\,]*)"));
    patternSet.add(Pattern.compile("asResiliencyIpAddress=(.[^\\,]*)"));
    patternSet.add(Pattern.compile("asResiliencyPeerIpAddress=(.[^\\,]*)"));
    patternSet.add(Pattern.compile("northboundVIpGateway=(.[^\\,]*)"));
    patternSet.add(Pattern.compile("northboundVIpAddress=(.[^\\,]*)"));
    patternSet.add(Pattern.compile("southboundVIpGateway=(.[^\\,]*)"));
    patternSet.add(Pattern.compile("southboundVIpAddress=(.[^\\,]*)"));
    patternSet.add(Pattern.compile("northboundIpAddress=(.[^\\,]*)"));
    patternSet.add(Pattern.compile("southboundIpAddress=(.[^\\,]*)"));
    patternSet.add(Pattern.compile("northboundGateway=(.[^\\,]*)"));
    patternSet.add(Pattern.compile("internalIp=(.[^\\,]*)"));
    patternSet.add(Pattern.compile("southVip=(.[^\\,]*)"));
    patternSet.add(Pattern.compile("southGateway=(.[^\\,]*)"));
    patternSet.add(Pattern.compile("northVip=(.[^\\,]*)"));
    patternSet.add(Pattern.compile("northGateway=(.[^\\,]*)"));

    patternSet.add(Pattern.compile("preSharedKey, value:(.*)"));
    patternSet.add(Pattern.compile("refNum, value:(.*)"));
    patternSet.add(Pattern.compile("preSharedKey = (.*)"));
    patternSet.add(Pattern.compile("refNum = (.*)"));
  }

  private SensitiveInfoEraser() {}

  public static String replaceSensitiveInfo(String content) {
    if (null == content) {
      return content;
    }
    String tempContent = content;
    for (Pattern pattern : patternSet) {
      Matcher matcher = pattern.matcher(content);
      while (matcher.find()) {
        tempContent = tempContent.replace(matcher.group(1), "***");
      }
    }
    return tempContent;
  }
}
