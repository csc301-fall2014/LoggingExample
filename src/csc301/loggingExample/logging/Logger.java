package csc301.loggingExample.logging;

import java.util.HashSet;
import java.util.Set;


public class Logger {

	public static enum Level {
		TRACE, DEBUG, INFO, WARN, ERROR, FATAL
	}
	
	
	//=========================================================================
	
	
	private Level minLevel;
	private Set<LogAppender> appenders = new HashSet<LogAppender>();
	
	
	public Logger(Level minLevel) {
		this.minLevel = minLevel;
	}
	
	public Logger() {
		this(Level.DEBUG);
	}
	
	
	//-------------------------------------------------------------------------
	// Observer pattern ...
	
	public void addAppender(LogAppender appender){
		appenders.add(appender);
	}
	
	public void removeAppender(LogAppender appender){
		appenders.remove(appender);
	}
	
	private void notifyAppenders(Level level, String message){
		LogMessage logMsg = new LogMessage.Builder()
							.level(level)
							.message(message)
							.build();
		for(LogAppender appender : appenders){
			appender.append(logMsg);
		}
	}
	
	//-------------------------------------------------------------------------
	
	
	protected boolean shouldEmitMessage(Level level){
		return level.ordinal() >= this.minLevel.ordinal();
	}
	
	public void log(Level level, String msg, Object ... args){
		if(shouldEmitMessage(level)){
			notifyAppenders(level, String.format(msg, args));
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
