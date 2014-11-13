package csc301.loggingExample.logging.formatter;

import csc301.loggingExample.logging.LogFormatter;
import csc301.loggingExample.logging.LogMessage;

public class Formatter1 implements LogFormatter {

	@Override
	public String format(LogMessage logMsg) {
		return logMsg.getLevel() + ": " + logMsg.getMessage();
	}

}
