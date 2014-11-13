package csc301.loggingExample;

import java.io.IOException;

import csc301.loggingExample.logging.Logger;

public class Main {


	public static void component1(){
		Logger logger = Logger.getLogger("Logger1");
		logger.trace("One");
		logger.debug("Two");
		logger.info("Three");
	}

	

	public static void component2(){
		Logger logger = Logger.getLogger("Logger2");
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


	public static void main(String[] args) throws IOException {
		component1();
		component2();
	}


}
