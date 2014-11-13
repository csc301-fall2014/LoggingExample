package csc301.loggingExample.logging;

public interface LogAppender {

	
	public void append(LogMessage logMessage);
	public void setFormatter(LogFormatter formatter);
	public LogFormatter getFormatter();
	
}
