package MultiThreading;

public class Counter{
    int count = 0;
    synchronized void increment() throws InterruptedException{
        count++;
        Thread.sleep(1000);
    }
}
