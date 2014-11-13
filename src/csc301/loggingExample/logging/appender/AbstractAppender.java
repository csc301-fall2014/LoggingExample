package csc301.loggingExample.logging.appender;

import csc301.loggingExample.logging.LogAppender;
import csc301.loggingExample.logging.LogFormatter;
import csc301.loggingExample.logging.formatter.Formatter1;

public abstract class AbstractAppender implements LogAppender {

	protected LogFormatter formatter;
	
	public AbstractAppender(LogFormatter fomatter) {
		this.formatter = fomatter;
	}

	public AbstractAppender() {
		this(new Formatter1()); // Set a default formatter
	}
	
	
	@Override
	public void setFormatter(LogFormatter formatter) {
		this.formatter = formatter;
	}

	@Override
	public LogFormatter getFormatter() {
		return formatter;
	}

}
