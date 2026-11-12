*** Deadlock ***

- so handling multithreading can make the code in the deadlock state

*** Runnable/Executable ***

both are functional interface - (definition of interface that contains only one abstract class)

They represent a task

Runnable is async and you do not want to get the results
But Callable is also async but it have results

*** 
Executor Service

- Way to create the thread
- Thread takes up memory so we need to create Exceutor service we can not keep creating thread and Threads are limited in the JVM.
- managing the thread is difficult