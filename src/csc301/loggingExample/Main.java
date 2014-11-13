package csc301.loggingExample;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import csc301.loggingExample.logging.Logger;
import csc301.loggingExample.logging.Logger.Level;
import csc301.loggingExample.logging.appender.ConsoleAppender;
import csc301.loggingExample.logging.appender.FileAppender;
import csc301.loggingExample.logging.formatter.Formatter1;
import csc301.loggingExample.logging.formatter.Formatter2;

public class Main {


	//	private static Logger logger1;
	//	private static Logger logger2;



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

	// A static block runs when the JVM first loads the class
	static {
		// Initialize the loggers ...

		Logger logger = new Logger(Level.TRACE);
		logger.addAppender(new ConsoleAppender(new Formatter1()));
		namedLoggers.put("Logger1", logger);


		try {
			logger = new Logger(Level.DEBUG);
			logger.addAppender(new ConsoleAppender(new Formatter2()));
			logger.addAppender(new FileAppender(new File("log.txt"), new Formatter1()));
			namedLoggers.put("Logger2", logger);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	
	public static Logger getLogger(String name){
		return namedLoggers.get(name);
	}

	
	//=========================================================================


	
	public static void main(String[] args) throws IOException {
		component1();
		component2();
	}


}
