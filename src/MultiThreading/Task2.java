package MultiThreading;

import java.util.concurrent.Callable;

public class Task2 implements Callable {
    public int getVale(){
        System.out.println("Task 2 "+ Thread.currentThread().getName());
        return 2;
    }

    public Object call() throws Exception{
        return null;
    }
}
