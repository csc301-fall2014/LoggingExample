package csc301.loggingExample.logging;

public class ConsoleAppender implements LogAppender {

	@Override
	public void append(String message) {
		System.out.println(message);
	}

}
