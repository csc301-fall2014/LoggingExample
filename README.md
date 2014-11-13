# Logging Example

Our [NetworkAppender](src/csc301/loggingExample/logging/appender/NetworkAppender.java) fakes an appender that writes the log message to a remote machine over the network.

For now, it doesn't do much, except for sleeping for 250 milliseconds (i.e. faking the time it takes for a slightly slow network request to complete).

We also changed the format of our console log messages - We print the timestamps including the milliseconds.    
Notice how the timing is now off - Our application sleeps for 1 second each time it goes through the loop, but writing the log message ("over the network") takes an additional 250 milliseconds.

__New Requirement:__ Our logging library must not slow down our application.

[step 13](https://github.com/csc301-fall2014/LoggingExample/tree/step13)
