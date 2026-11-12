package MultiThreading;

public class Task1 implements Runnable{
    public void print(){
        System.out.println("Task 1 " + Thread.currentThread().getName());
    }

    public void run(){
        return;
    }
}
