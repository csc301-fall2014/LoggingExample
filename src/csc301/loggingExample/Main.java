package csc301.loggingExample;

import java.io.File;
import java.io.IOException;

import csc301.loggingExample.logging.ConsoleAppender;
import csc301.loggingExample.logging.FileAppender;
import csc301.loggingExample.logging.Formatter1;
import csc301.loggingExample.logging.Formatter2;
import csc301.loggingExample.logging.Logger;
import csc301.loggingExample.logging.Logger.Level;

public class Main {

	
	private static Logger logger1;
	private static Logger logger2;

	
	
	public static void component1(){
		logger1.trace("One");
		logger1.debug("Two");
		logger1.info("Three");
	}
	
	
	public static void component2(){
		for (int i = 0; i < 60; i++) {

			try {

				long start = System.currentTimeMillis();
				Thread.sleep(1000);
				long end = System.currentTimeMillis();
				logger2.debug("Slept for %d milliseconds.", end - start);
				logger2.trace("** Slept for %d milliseconds.", end - start);
			} catch (InterruptedException e) {
				// Exit the loop, if someone interrupts us from sleeping
				break;
			}
		}
	}



	public static void main(String[] args) throws IOException {
		
		logger1 = new Logger(Level.TRACE);
		logger2 = new Logger(Level.DEBUG); 
		
		logger1.addAppender(new ConsoleAppender(new Formatter1()));
		logger2.addAppender(new ConsoleAppender(new Formatter2()));
		logger2.addAppender(new FileAppender(new File("log.txt"), new Formatter1()));
		
		component1();
		component2();
	}

	
}
