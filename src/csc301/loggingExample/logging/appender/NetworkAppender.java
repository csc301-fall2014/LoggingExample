package csc301.loggingExample.logging.appender;

import csc301.loggingExample.logging.LogFormatter;
import csc301.loggingExample.logging.LogMessage;

public class NetworkAppender extends AbstractAppender {

	public NetworkAppender() {
		super();
	}
	
	public NetworkAppender(LogFormatter formatter) {
		super(formatter);
	}
	
	
	@Override
	public void append(LogMessage logMessage) {
		try {
			Thread.sleep(250);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}


}
