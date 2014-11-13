package csc301.loggingExample.logging.appender;

import csc301.loggingExample.logging.LogMessage;

public class NetworkAppender extends AbstractAppender {

	@Override
	public void append(LogMessage logMessage) {
		// We still pretend to send this message to a remote server ...
		// Only this time we do it in a separate thread.
		
		Thread thread = new Thread(new Runnable() {
			
			@Override
			public void run() {
				try {
					Thread.sleep(250);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			
		});
		
		thread.start();
	}


}
