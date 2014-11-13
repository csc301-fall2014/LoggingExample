package csc301.loggingExample.logging.appender;

import csc301.loggingExample.logging.LogFormatter;
import csc301.loggingExample.logging.LogMessage;

public class ConsoleAppender extends AbstractAppender {

	public ConsoleAppender() {
		super();
	}
	
	public ConsoleAppender(LogFormatter formatter) {
		super(formatter);
	}
	
	@Override
	public void append(LogMessage logMsg) {
		System.out.println(formatter.format(logMsg));
	}


}
