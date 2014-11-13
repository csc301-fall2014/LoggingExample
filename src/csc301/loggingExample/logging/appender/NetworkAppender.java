package csc301.loggingExample.logging.appender;

import csc301.loggingExample.logging.LogMessage;

public class NetworkAppender extends AbstractAppender {

	@Override
	public void append(LogMessage logMessage) {
		try {
			Thread.sleep(250);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}


}
