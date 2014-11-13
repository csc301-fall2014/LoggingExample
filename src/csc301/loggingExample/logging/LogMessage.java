package csc301.loggingExample.logging;

import java.util.Date;

import csc301.loggingExample.logging.Logger.Level;

public class LogMessage {

	private Level level;
	private String message;
	private Date time;
	
	public LogMessage(Level level, String message, Date time) {
		this.level = level;
		this.time = time;
		this.message = message;
	}
	
	public LogMessage(Level level, String message) {
		this(level, message, new Date());
	}

	public Level getLevel() {
		return level;
	}

	public String getMessage() {
		return message;
	}

	public Date getTime() {
		return time;
	}
	
}
