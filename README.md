# Logging Example

In this step, we set up our loggers based on a [configuration file](logging.conf).     
This will allow us to change the way our loggers work, without recompiling the code.


For the sake of this example, we came up with a simple (and fairly limited) text format for our configuration file. In [`LoggingUtil.java`](src/csc301/loggingExample/logging/LoggingUtil.java), we have code that parses a configuration file, and creates the appropriate loggers.

In [Main.java](src/csc301/loggingExample/Main.java), we use the utility methods to load loggers from a configuration file, and also define a default logger as a fallback option.

In [step 16](https://github.com/csc301-fall2014/LoggingExample/tree/step16), we reorganize the code, and set it up so that loggers can be loaded at startup without any code necessary.
