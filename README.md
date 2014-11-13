# Logging Example

This is a good opportunity to reorganize and cleaup our code:
 * We organize our source files into packages.
 * We notice that [`LogMessage`](src/csc301/loggingExample/logging/LogMessage.java)'s constructor is starting to look too ugly. Instead of keeping a telescoping constructor, we apply the Builder design pattern.


__New Requirement:__ We would like to write log messages to a remote machine (i.e. over the network).

In [step 12](https://github.com/csc301-fall2014/LoggingExample/tree/step12), we fake an appender that does exactly that.
