package MultiThreading;

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
    public static void main(String[] args) throws InterruptedException {
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

