package csc301.loggingExample.logging.appender;

import csc301.loggingExample.logging.LogAppender;
import csc301.loggingExample.logging.LogFormatter;
import csc301.loggingExample.logging.LogMessage;

public class ConsoleAppender implements LogAppender {

	private LogFormatter formatter;	

	public ConsoleAppender(LogFormatter formatter) {
		this.formatter = formatter;
	}
	
	

	@Override
	public void append(LogMessage logMsg) {
		System.out.println(formatter.format(logMsg));
	}

	@Override
	public void setFormatter(LogFormatter formatter) {
		this.formatter = formatter;
	}

	@Override
	public LogFormatter getFormatter() {
		return this.formatter;
	}

}
