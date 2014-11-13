# Logging Example

This time, the [`Logger`](src/csc301/loggingExample/logging/Logger.java) class notifies the appender (i.e. it calls each appender's `append` method) in a separate thread.

Notice that we change [`NetworkAppender.java`](src/csc301/loggingExample/logging/appender/NetworkAppender.java) back to the way it was before.

From now on, developers who implement new appenders, shouldn't concern themselves with any threading issues.

In [step 15](https://github.com/csc301-fall2014/LoggingExample/tree/step15), we will introduce a cool feature, that will make our library easier to use.
