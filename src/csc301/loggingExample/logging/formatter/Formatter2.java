package csc301.loggingExample.logging.formatter;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import csc301.loggingExample.logging.LogFormatter;
import csc301.loggingExample.logging.LogMessage;

public class Formatter2 implements LogFormatter {

	DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss.SSS");
	
	@Override
	public String format(LogMessage logMsg) {
		return String.format("%s [%s]: %s", dateFormat.format(logMsg.getTime()), 
				logMsg.getThread(), logMsg.getMessage());
	}

}
