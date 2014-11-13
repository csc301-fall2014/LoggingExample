package csc301.loggingExample;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileLogger extends Logger {

	private FileWriter logFile;

	public FileLogger(Level minLevel, File filename) throws IOException {
		super(minLevel);
		logFile = new FileWriter(filename);
	}
	
	
	@Override
	public void log(Level level, String msg, Object... args) {
		if(shouldEmitMessage(level)){
			try {
				logFile.write(level.toString() + ": " + String.format(msg, args).trim() + "\n");
				// What would happen if we don't flush the buffer every time?
				logFile.flush();
			} catch (IOException e) {
				super.error(e.getMessage());
			}
		}
	}
}
