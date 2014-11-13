package csc301.loggingExample.logging;

public class Formatter1 implements LogFormatter {

	@Override
	public String format(LogMessage logMsg) {
		return logMsg.getLevel() + ": " + logMsg.getMessage();
	}

}
