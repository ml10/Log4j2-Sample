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


		log.info("Info : number is " + infostr);
		log.warn("Warning : number is " + infostr2);
		log.debug("Debug : number is " + infostr2);
		log.error("Error : number is " + infostr);
		log.fatal("Fatal : number is " + infostr);
	}
}