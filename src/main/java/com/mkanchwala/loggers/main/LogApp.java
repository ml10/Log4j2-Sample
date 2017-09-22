package com.mkanchwala.loggers.main;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;

public class LogApp {
	static Logger log = LogManager.getLogger(LogApp.class.getName());
	public static void main(String[] args) throws IOException {
		//System.out.println("/******* Choose a number *******/ \n");
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//int number = Integer.valueOf(br.readLine());
		String infostr = "http://10.144.1.10";

		String infostr2 = "{SimpleAndComplexParameter{name='preSharedKey', "
				+ "definition=Optional.empty}, names='null, params=null, value=Optional[ParameterValue{value=2RAz-sEVT-9qVU-MaUP}]},"
				+ " {SimpleAndComplexParameter{name='refNum', "
				+ "definition=Optional.empty}, names='null, params=null, value=Optional[ParameterValue{value=61970}]}";

		String infostr3 = "<raml xmlns=\"raml21.xsd\">\n" +
				"    <cmData type=\"actual\">\n" +
				"        <header>\n" +
				"            <log dateTime=\"2017-05-10T13:51:18+08:00\" action=\"\"/>\n" +
				"        </header>\n" +
				"        <managedObject class=\"CMP\" operation=\"update\" distName=\"/BTSMED-1/CERTH-1/CMP-1\">\n" +
				"            <p name=\"caSubjectName\">C=CN,O=NSN,CN=LTE_TRS_IPsec_ALL_CA3</p>\n" +
				"            <p name=\"cmpId\">1</p>\n" +
				"            <p name=\"eeSubjectName\">CN = L9153200322, O=Nokia Networks</p>\n" +
				"            <p name=\"preSharedKey\">AAAA-WWWW-vk5K-ASD</p>\n" +
				"            <p name=\"refNum\">8888</p>\n" +
				"            <p name=\"password\">Nokia123@Q</p>" +
				"            <p name=\"serverHost\">10.69.125.66</p>\n" +
				"            <p name=\"serverPort\">8081</p>\n" +
				"        </managedObject>\n" +
				"    </cmData>\n" +
				"</raml>";
		log.info("Info : number is " + infostr);
		log.warn("Warning : number is " + infostr2);
		log.debug("Debug : number is " + infostr3);
		log.error("Error : number is " + infostr);
		log.fatal("Fatal : number is " + infostr);
	}
}