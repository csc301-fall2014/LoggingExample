package csc301.loggingExample;

public class Main {

	
	private static boolean DEBUG = true;
	
	
	public static void main(String[] args) {

		for (int i = 0; i < 60; i++) {
			
			try {
				
				long start = System.currentTimeMillis();
				Thread.sleep(1000);
				long end = System.currentTimeMillis();
				
				if(DEBUG){
					System.out.println(String.format("DEBUG: Slept for %d milliseconds.", end - start));
				}
				
			} catch (InterruptedException e) {
				// Exit the loop, if someone interrupts us from sleeping
				break;
			}
			
		}
		
	}

}
