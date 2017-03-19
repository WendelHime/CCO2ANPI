package br.com.cco2anpi.tools;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

public class LogUtil {
	   public static Logger getInstance() {
		BasicConfigurator.configure();

	      String callingClassName = 
	         Thread.currentThread().getStackTrace()[2].getClass().getCanonicalName();
	      return Logger.getLogger(callingClassName);
	   }
	}