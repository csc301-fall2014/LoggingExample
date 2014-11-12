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
	
	
	public static void trace(String msg, Object ... args){
		log(Level.TRACE, msg, args);
	}
	
	public static void debug(String msg, Object ... args){
		log(Level.DEBUG, msg, args);
	}
	
	public static void info(String msg, Object ... args){
		log(Level.INFO, msg, args);
	}
	
	public static void warn(String msg, Object ... args){
		log(Level.WARN, msg, args);
	}
	
	public static void error(String msg, Object ... args){
		log(Level.ERROR, msg, args);
	}
	
	public static void fatal(String msg, Object ... args){
		log(Level.FATAL, msg, args);
	}
	
	
	
}
