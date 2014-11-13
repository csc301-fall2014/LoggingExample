# Logging Example

In order to deal with out problem, we change the [`NetworkAppender`](src/csc301/loggingExample/logging/appender/NetworkAppender.java) to do its work in a separate thread.

When we run the code, we see that our application actually wakes up every second (it might be off by 1 millisecond every now and then).

That's great, we took care of the problem with network-appender, but what about any other appender who might be slow?

In [step 14](https://github.com/csc301-fall2014/LoggingExample/tree/step14) we make sure that appenders always run their `append` method in a separate thread.
