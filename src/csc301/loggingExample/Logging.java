package csc301.loggingExample;

public class Logging {

	private static boolean DEBUG = true;
	
	// Notice the synta below, this is a var-args method.
	// It takes 1 String argument, and 0 or more Object arguments.
	public static void debug(String msg, Object ... args){
		if(DEBUG){
			System.out.println("DEBUG: " + String.format(msg, args));
		}
	}
	
}
