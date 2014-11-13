# Logging Example

__New Requirement:__ We want to be able to print log message of different importance/level.    
For example, these are failry standard terminologies:
 * `TRACE` - Low level tracing of some part of the program.
 * `DEBUG` - Slightly higher level debugging.
 * `INFO`  - General tracking of the system.
 * `WARN`  - The system is doing something unexpected.
 * `ERROR` - Get someone to look at it.
 * `FATAL` - Get someone to look at it NOW!

Traditionally, we use only use `TRACE` and `DEBUG` in development. In production systems, we want to see message of `INFO` level and higher.

In [step 4](https://github.com/csc301-fall2014/LoggingExample/tree/step4), we introduce the notion of levels.
