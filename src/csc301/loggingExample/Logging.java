package csc301.loggingExample;

public class Logging {

	
	public static enum Level {
		TRACE, DEBUG, INFO, WARN, ERROR, FATAL
	}
	
	
	private static Level MIN_LEVEL = Level.DEBUG;
	
	
	public static void log(Level level, String msg, Object ... args){
		if(level.ordinal() >= MIN_LEVEL.ordinal()){
			System.out.println("DEBUG: " + String.format(msg, args));
		}
	}
	
}
