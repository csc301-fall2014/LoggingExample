package csc301.loggingExample.logging;

public class ConsoleAppender implements LogAppender {

	private LogFormatter formatter;	

	public ConsoleAppender(LogFormatter formatter) {
		this.formatter = formatter;
	}
	
	

	@Override
	public void append(LogMessage logMsg) {
		System.out.println(formatter.format(logMsg));
	}

	@Override
	public void setFormatter(LogFormatter formatter) {
		this.formatter = formatter;
	}

	@Override
	public LogFormatter getFormatter() {
		return this.formatter;
	}

}
