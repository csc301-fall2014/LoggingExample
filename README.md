# Logging Example

In this step, we initialize all of the loggers in a static block (code that runs when the JVM first loads the class).     
We store all Logger objects in a map, where the loggers names are the keys.

__New Requirement:__ In addition to the timestamp and log-level, our `LogMessage` class should also keep track of the current-thread.

Let's see [step 11](https://github.com/csc301-fall2014/LoggingExample/tree/step11)
