package csc301.loggingExample.logging;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileAppender implements LogAppender {

	private FileWriter logFile;

	public FileAppender(File filename) throws IOException {
		logFile = new FileWriter(filename);
	}
	

	@Override
	public void append(String message) {
		try {
			logFile.write(message.trim() + "\n");
			logFile.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
