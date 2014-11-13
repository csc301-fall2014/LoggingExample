package csc301.loggingExample.logging.appender;

import csc301.loggingExample.logging.LogMessage;

public class NetworkAppender extends AbstractAppender {

	@Override
	public void append(LogMessage logMessage) {
		// Let's pretend like we're sending this message to a remote server ...
		// Instead of actually sending the data, we'll just sleep for 250 ms.
		try {
			Thread.sleep(250);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}


}
