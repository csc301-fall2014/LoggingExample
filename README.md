# Logging Example

We extended our [`Logger`](src/csc301/loggingExample/Logger.java) class with a [`FileLogger`](src/csc301/loggingExample/FileLogger.java) class.

Notice that the `minLevel` instance variable in the `Logger` class is private, and is not accessible to `FileLogger`.     
By doing so, we tell other developers that it is the `Logger`'s responsibility to filter messages based on the min' level. Subclasses can use the `protected boolean shouldEmitMessage(Level level)` method.


__New Requirement:__ We want the same log messages to be written to _both_ the console and a file (and perhaps other places as well).

Let's see how we deal with that in [step 8](https://github.com/csc301-fall2014/LoggingExample/tree/step8).
