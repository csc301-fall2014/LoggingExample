package csc301.loggingExample;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import csc301.loggingExample.logging.Logger;
import csc301.loggingExample.logging.LoggingUtil;
import csc301.loggingExample.logging.appender.ConsoleAppender;

public class Main {


	public static void component1(){
		Logger logger = getLogger("Logger1");
		logger.trace("One");
		logger.debug("Two");
		logger.info("Three");
	}

	

	public static void component2(){
		Logger logger = getLogger("Logger2");
		for (int i = 0; i < 60; i++) {

			try {

				long start = System.currentTimeMillis();
				Thread.sleep(1000);
				long end = System.currentTimeMillis();
				logger.debug("Slept for %d milliseconds.", end - start);
				logger.trace("** Slept for %d milliseconds.", end - start);
			} catch (InterruptedException e) {
				// Exit the loop, if someone interrupts us from sleeping
				break;
			}
		}
	}


	//=========================================================================


	private static Map<String, Logger> namedLoggers = new HashMap<String, Logger>();
	private static Logger defaultLogger;

	private static void initLoggers(File configFile){
		defaultLogger = new Logger();
		defaultLogger.addAppender(new ConsoleAppender());
		
		try {
			Iterator<Logger> itr = LoggingUtil.loadLoggersFromConfigFile(configFile);
			while(itr.hasNext()){
				Logger logger = itr.next();
				namedLoggers.put(logger.getName(), logger);
			}
		} catch (IOException e) {
			e.printStackTrace();
			System.err.println("The default console-logger will be used as a fallback.");
		}
	}

	
	public static Logger getLogger(String name){
		if(namedLoggers.containsKey(name)){
			return namedLoggers.get(name);
		} else {
			return defaultLogger;
		}
	}

	
	//=========================================================================


	
	public static void main(String[] args) throws IOException {
		initLoggers(new File("logging.conf"));
		component1();
		component2();
	}


}
