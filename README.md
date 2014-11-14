# Logging Example

We moved all of our static logger setup to [`Logger.java`](src/csc301/loggingExample/logging/Logger.java), and wrote the code so that:
 * If the `LOGGING_CONFIG` environment variable is set, we will use its value as the path to the configuration file.
 * Otherwise, we will look for a file called `logging.conf`, at the root of our project.
 * If that file doesn't exist, we'll just use the default logger (that uses a console appender).

Notice how, in [`Main.java`](src/csc301/loggingExample/Main.java), we do not have do any work to set up loggers.     

Also, the use of an environment variable makes it easier to deply code that uses our library.     
For example:
 * In a production environment, we can set the `LOGGING_CONFIG` to one configuration file (that filters messages lower than INFO-level, and writes log messages to file(s) and network).
 * In development, we can set the `LOGGING_CONFIG` to a different configuration file (that doesn't filter any messages, and only writes to the console).
