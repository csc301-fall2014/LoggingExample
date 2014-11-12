package csc301.loggingExample;

public class Main {

	
	public static void main(String[] args) {

		for (int i = 0; i < 60; i++) {
			
			try {
				
				long start = System.currentTimeMillis();
				Thread.sleep(1000);
				long end = System.currentTimeMillis();
				Logging.log(Logging.Level.DEBUG, "Slept for %d milliseconds.", end - start);
				Logging.log(Logging.Level.TRACE, "** Slept for %d milliseconds.", end - start);
			} catch (InterruptedException e) {
				// Exit the loop, if someone interrupts us from sleeping
				break;
			}
			
		}
		
	}

}
