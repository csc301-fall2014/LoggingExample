package csc301.loggingExample.logging.appender;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import csc301.loggingExample.logging.LogAppender;
import csc301.loggingExample.logging.LogFormatter;
import csc301.loggingExample.logging.LogMessage;

public class FileAppender implements LogAppender {

	private FileWriter logFile;
	private LogFormatter formatter;

	public FileAppender(File filename, LogFormatter formatter) throws IOException {
		logFile = new FileWriter(filename);
		this.formatter = formatter;
	}
	

	@Override
	public void append(LogMessage logMsg) {
		try {
			logFile.write(formatter.format(logMsg)+ "\n");
			logFile.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
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
