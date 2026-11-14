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
- Execute does not return anything, so we cannot directly track whether the task has completed or waiting for its execution. ---> So we use submit


Future Object 

Limitation of future that comparable solves

- future does not have a callback services
- Multiple future can not be combined together

CompletableFuture

- to solve number 1 --->
  CompletableFuture.supplyAsync(() -> {
  System.out.println("Fetching the name");
  return "Shivam";
  }).thenAccept((String name) -> {
  System.out.println("Sending welcome email to " + name);
  });
  
  Completable future gets its thread from the frockjoinpool.common pool by default.