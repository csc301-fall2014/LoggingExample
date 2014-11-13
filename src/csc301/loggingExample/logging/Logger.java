package csc301.loggingExample.logging;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import csc301.loggingExample.logging.appender.ConsoleAppender;


public class Logger {

	public static enum Level {
		TRACE, DEBUG, INFO, WARN, ERROR, FATAL
	}
	
	//=========================================================================
	
	private static Map<String, Logger> namedLoggers;
	private static Logger defaultLogger;
	
	// Load loggers from a configuration when the program starts ...
	static {
		
		namedLoggers = new HashMap<String, Logger>();
		File defaultConfigFile = new File("logging.conf"); 
		
		// Override the default configuration file using an environment variable
		if(System.getenv("LOGGING_CONFIG") != null){
			initLoggers(new File(System.getenv("LOGGING_CONFIG")));
		} else if (defaultConfigFile.isFile()){
			initLoggers(defaultConfigFile);
		} else {
			initLoggers(null);
		}
	}
	
	
	

	private static void initLoggers(File configFile){
		defaultLogger = new Logger();
		defaultLogger.addAppender(new ConsoleAppender());
		
		if(configFile != null){
			
			try {
				
				Iterator<Logger> itr = LoggingUtil.loadLoggersFromConfigFile(configFile);
				while(itr.hasNext()){
					Logger logger = itr.next();
					namedLoggers.put(logger.getName(), logger);
				}
				
			} catch (IOException e) {
				e.printStackTrace();
				System.err.println("The default console-logger will be used as a fallback.");
			}
		}
	}

	
	
	public static Logger getLogger(String name){
		if(namedLoggers.containsKey(name)){
			return namedLoggers.get(name);
		} else {
			return defaultLogger;
		}
	}
	
	
	//=========================================================================
	
	private String name;
	private Level minLevel;
	private Set<LogAppender> appenders = new HashSet<LogAppender>();
	
	public Logger(String name, Level minLevel) {
		this.name = name;
		this.minLevel = minLevel;
	}
	
	public Logger(Level minLevel) {
		this(null, minLevel);
	}
	
	public Logger() {
		this(Level.DEBUG);
	}
	
	
	//-------------------------------------------------------------------------
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
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
		// We will call the appenders' append method in a separate thread.
		// Q1: Why are we creating the LogMessage object in the current thread?
		// Q2: Why did we have to declare logMsg as final? 
		
		final LogMessage logMsg = new LogMessage.Builder()
							.level(level)
							.message(message)
							.build();
		
		new Thread(new Runnable() {
			@Override
			public void run() {
				for(LogAppender appender : appenders){
					appender.append(logMsg);
				}
			}
		}).start();
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
