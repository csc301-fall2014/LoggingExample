package csc301.loggingExample.logging;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class Formatter2 implements LogFormatter {

	DateFormat dateFormat = new SimpleDateFormat();
	
	@Override
	public String format(LogMessage logMsg) {
		return dateFormat.format(logMsg.getTime()) + ": " + logMsg.getMessage();
	}

}
