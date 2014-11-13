package csc301.loggingExample.logging.appender;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import csc301.loggingExample.logging.LogFormatter;
import csc301.loggingExample.logging.LogMessage;

public class FileAppender extends AbstractAppender {

	private FileWriter logFile;

	public FileAppender(File filename, LogFormatter formatter) throws IOException {
		logFile = new FileWriter(filename);
		setFormatter(formatter);
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
	
}
