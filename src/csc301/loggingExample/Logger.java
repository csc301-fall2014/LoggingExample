package csc301.loggingExample;


public class Logger {

	public static enum Level {
		TRACE, DEBUG, INFO, WARN, ERROR, FATAL
	}
	
	
	//=========================================================================
	
	
	private Level minLevel;
	
	
	public Logger(Level minLevel) {
		this.minLevel = minLevel;
	}
	
	public Logger() {
		this(Level.DEBUG);
	}
	
	
	protected boolean shouldEmitMessage(Level level){
		return level.ordinal() >= this.minLevel.ordinal();
	}
	
	public void log(Level level, String msg, Object ... args){
		if(shouldEmitMessage(level)){
			System.out.println(level.toString() + ": " + String.format(msg, args));
		}
	}
	
	
	public void trace(String msg, Object ... args){
		log(Level.TRACE, msg, args);
	}
	
	public void debug(String msg, Object ... args){
		log(Level.DEBUG, msg, args);
	}
	
	public void info(String msg, Object ... args){
		log(Level.INFO, msg, args);
	}
	
	public void warn(String msg, Object ... args){
		log(Level.WARN, msg, args);
	}
	
	public void error(String msg, Object ... args){
		log(Level.ERROR, msg, args);
	}
	
	public void fatal(String msg, Object ... args){
		log(Level.FATAL, msg, args);
	}
	
}
