package csc301.loggingExample.logging;

import java.util.Date;

import csc301.loggingExample.logging.Logger.Level;

public class LogMessage {
	
	public static class Builder{
		
		// Set default values
		private Level level    = Level.DEBUG;
		private String message = null;
		private Date time      = new Date();
		private String thread  = Thread.currentThread().getName();
		
		
		public Builder level(Level level){
			this.level = level;
			return this;
		}
		
		public Builder message(String message){
			this.message = message;
			return this;
		}
		
		public Builder time(Date time){
			this.time = time;
			return this;
		}
		
		public Builder thread(String thread){
			this.thread = thread;
			return this;
		}
		
		
		public LogMessage build(){
			if(message == null){
				throw new IllegalArgumentException("Message was not set");
			}
			return new LogMessage(this);
		}
	}
	

	//=========================================================================
	
	
	private Level level;
	private String message;
	private Date time;
	private String thread;
	
	private LogMessage(Builder builder) {
		this.level = builder.level;
		this.time = builder.time;
		this.message = builder.message;
		this.thread = builder.thread;
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
	
	public String getThread() {
		return thread;
	}
}
