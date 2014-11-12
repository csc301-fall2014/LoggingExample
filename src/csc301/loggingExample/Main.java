package csc301.loggingExample;

import csc301.loggingExample.Logger.Level;

public class Main {

	
	private static Logger logger1 = new Logger(Level.TRACE);
	private static Logger logger2 = new Logger(Level.DEBUG);

	
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



	public static void main(String[] args) {
		component1();
		component2();
	}

	
}
