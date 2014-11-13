package csc301.loggingExample.logging;

import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

import csc301.loggingExample.logging.Logger.Level;
import csc301.loggingExample.logging.appender.ConsoleAppender;
import csc301.loggingExample.logging.appender.FileAppender;
import csc301.loggingExample.logging.appender.NetworkAppender;
import csc301.loggingExample.logging.formatter.Formatter1;
import csc301.loggingExample.logging.formatter.Formatter2;

public class LoggingUtil {

	
	public static Iterator<Logger> loadLoggersFromConfigFile(File configFile) throws IOException{
		Collection<Logger> loggers = new LinkedList<Logger>();
		Scanner scanner = new Scanner(configFile);
		Logger currentLogger = null;
		
		while(scanner.hasNextLine()){
			String line = scanner.nextLine().trim();
			
			// Skip blank and comment lines
			if(line.isEmpty() || line.startsWith("#")){
				continue;
			}
			
			// The current line defines a new logger
			else if(line.startsWith("Logger")){
				if(currentLogger != null){
					loggers.add(currentLogger);
				}
				currentLogger = parseLoggerLine(line);
			}
			
			// The current line defines a new appender for the current logger
			else if(line.startsWith("Appender")){
				currentLogger.addAppender(parseAppenderLine(line));
			}
		}
		
		
		scanner.close();
		
		if(currentLogger != null){
			loggers.add(currentLogger);
		}
		
		return loggers.iterator();
	}
	
	
	
	
	private static Logger parseLoggerLine(String line){
		// Parse the line, and create the new named logger
		String[] splitLine = line.split("\\s+");
		String name = splitLine[1];
		Level minLevel = Level.valueOf(splitLine[2]);
		return new Logger(name, minLevel);
	}
	
	
	private static LogAppender parseAppenderLine(String line) throws IOException{
		String[] splitLine = line.split("\\s+");
		String appenderType = splitLine[1];
		
		if("Console".equals(appenderType)){
			return parseConsoleAppenderLine(splitLine);
		} else if("File".equals(appenderType)){
			return parseFileAppenderLine(splitLine);
		} else if("Network".equals(appenderType)){
			return parseNetworkAppenderLine(splitLine);
		} else {
			throw new IllegalArgumentException("Unknown appender type '" + appenderType + "'.");
		}
	}
	
	
	
	private static LogAppender parseConsoleAppenderLine(String[] splitLine){
		LogAppender appender = new ConsoleAppender();
		if(splitLine.length > 2){
			appender.setFormatter(parseFormatter(splitLine[2]));
		}
		return appender;
	}


	private static LogAppender parseFileAppenderLine(String[] splitLine) throws IOException{
		LogAppender appender = new FileAppender(new File(splitLine[2]));
		if(splitLine.length > 3){
			appender.setFormatter(parseFormatter(splitLine[3]));
		}
		return appender;
	}
	
	private static LogAppender parseNetworkAppenderLine(String[] splitLine){
		LogAppender appender = new NetworkAppender();
		if(splitLine.length > 2){
			appender.setFormatter(parseFormatter(splitLine[2]));
		}
		return appender;
	}

	
	private static LogFormatter parseFormatter(String type) {
		if("Formatter1".equals(type)){
			return new Formatter1();
		} else if("Formatter2".equals(type)){
			return new Formatter2();
		} else {
			throw new IllegalArgumentException("No such formatter type, '" + type + "'.");
		}
	}
	
}
