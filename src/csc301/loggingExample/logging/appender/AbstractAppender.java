package csc301.loggingExample.logging.appender;

import csc301.loggingExample.logging.LogAppender;
import csc301.loggingExample.logging.LogFormatter;
import csc301.loggingExample.logging.formatter.Formatter1;

public abstract class AbstractAppender implements LogAppender {

	// Set a default formatter
	protected LogFormatter formatter = new Formatter1();


	@Override
	public void setFormatter(LogFormatter formatter) {
		this.formatter = formatter;
	}

	@Override
	public LogFormatter getFormatter() {
		return formatter;
	}

}
