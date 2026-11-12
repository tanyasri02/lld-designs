package MultiThreading;

import java.util.concurrent.*;

public class Main {

    // To understand the threading and there there state

    /*public static void main(String[] args) throws InterruptedException{
        Thread t1 = new Thread(() ->{
            for(int i=1; i<=9; i=i+2) {
                System.out.println(i);

                try{
                    Thread.sleep(5000);
                }catch (InterruptedException e){

                }
            }
        });

        Thread t2 = new Thread(() ->{
            for(int i=2; i<=10; i=i+2){
                System.out.println(i);

                try{
                    Thread.sleep(1000);
                }catch (InterruptedException e){

                }
            }
        });

        System.out.println(t1.getState());
        t1.start();

        Thread.sleep(1000); // Important else both can start

        System.out.println(t1.getState());
        t2.start();

        System.out.println(t1.getState());

        Thread.sleep(5000);
        t1.join();
        System.out.println(t1.getState());
    } */


    // Synchronized

    /* public static void main(String[] args) throws InterruptedException {
        Counter c1 = new Counter();

        Thread t1 = new Thread(() ->{
            try{
                c1.increment();
            }catch (InterruptedException e){
                throw new RuntimeException();
            }
        });

        Thread t2 = new Thread(() ->{
            try{
                c1.increment();
            }catch (InterruptedException e){
                throw new RuntimeException();
            }
        });

        t1.start();
        System.out.println(c1);

        t2.start();
        System.out.println(c1);

        System.out.println(t2.getState());

    }*/


    //  Synchronized
    /* public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();

        Thread t1 = new Thread(() -> {
            for(int i=1;i<=10;i++){
                try {
                    counter.increment();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });


        Thread t2 = new Thread(() -> {
            for(int i=1;i<=10;i++){
                try {
                    counter.increment();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println(counter.count);
    }*/

    //deadlock

    /*public static void main(String[] args) throws InterruptedException {
        BankAccount account1 = new BankAccount();
        BankAccount account2 = new BankAccount();

        Thread t1 = new Thread(() -> {
            synchronized (account1){
                System.out.println("Thread 1 has taken the lock on account 1");
                account1.changeBalance();
                synchronized (account2){
                    System.out.println("Thread 1 has taken the lock on account 2");
                    account2.changeBalance();
                }
            }


        });

        Thread t2 = new Thread(() -> {
            synchronized (account2){
                System.out.println("Thread 2 has taken the lock on account 2");
                account2.changeBalance();
                synchronized (account1){
                    System.out.println("Thread 2 has taken the lock on account 1 ");
                    account1.changeBalance();
                }
            }
        });

        t1.start();
        t2.start();

        Thread.sleep(1000);
        System.out.println(t1.getState());;
        System.out.println(t2.getState());
    }*/

    // to solve the deadlock - follow the ordering so that cpu has enough time to process the lock

    /*public static void main(String[] args) throws InterruptedException {
        BankAccount account1 = new BankAccount();
        BankAccount account2 = new BankAccount();

        Thread t1 = new Thread(() -> {
            synchronized (account1){
                System.out.println("Thread 1 has taken the lock on account 1");
                account1.changeBalance();
                synchronized (account2){
                    System.out.println("Thread 1 has taken the lock on account 2");
                    account2.changeBalance();
                }
            }
        });

        Thread t2 = new Thread(() -> {
            synchronized (account1){
                System.out.println("Thread 2 has taken the lock on account 1");
                account2.changeBalance();
                synchronized (account2){
                    System.out.println("Thread 2 has taken the lock on account 2 ");
                    account1.changeBalance();
                }
            }
        });

        t1.start();
        t2.start();

        Thread.sleep(1000);
        System.out.println(t1.getState());;
        System.out.println(t2.getState());
    }*/
    
    //Callable and Runnable

    /*public static void main(String[] args){
        Task1 runableTask = new Task1();
        Task2 callableTask = new Task2();

        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.submit(runableTask);
        executorService.submit(callableTask);
    }*/

    // Use lambda function for Runnable and Callable

    /* public static void main(String[] args) throws ExecutionException, InterruptedException {
        /*Runnable runnableTask = () -> {
            System.out.println("Task 1 is excuting " + Thread.currentThread().getName());
        };

        Callable callableTask = () -> {
            System.out.println("Fetching" + Thread.currentThread().getName());
            return 100;
        };*/

        /* ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.submit(() -> {
            System.out.println("Task 1 is excuting " + Thread.currentThread().getName());
        });

        Future<Integer> future =  executorService.submit(() -> {
            System.out.println("Fetching" + Thread.currentThread().getName());
            return 100;
        });

        System.out.println(future.get());
    }*/

    // Executor Services
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        // shown above tooo.

        executorService.execute(() -> {
            System.out.println("Task 1 is executing " + Thread.currentThread().getName());
        });

        executorService.execute(() -> {
            System.out.println("Task 2 is executing " + Thread.currentThread().getName());
        });

        executorService.execute(() -> {
            System.out.println("Task 3 is executing " + Thread.currentThread().getName());
        });


        System.out.println("Main is executing " + Thread.currentThread().getName());
    }

}

/*
state ->
1. Started - new
2. TimeWaited -> waiting
3. Runnable -> running
4. Terminated -> finished

Join() -> makes current thread execution until the current thread finished it's execution

Synchronized = That blocks the thread is running
 */

