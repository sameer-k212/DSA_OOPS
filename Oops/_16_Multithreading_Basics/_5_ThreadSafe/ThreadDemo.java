package Oops.Threads._5_ThreadSafe;

/**
 * whenever there is functional interface we can use lambda expression. so Runnable is
 * Functional Interface that's why we can use lambda expression for runnable interface.
 *
 * value is not still 2000 because it might be chance
 * where t1 and t2 got count at same time let say count = 3 then at that moment only
 * one time value of the count  = 4 will increase, that's why multithreading is not safe
 * some time
 */

class Counter{
    int count = 0;

//    public void increment(){
//        count++;
//    }

    public synchronized void increment(){         // thread safety achieved
        count++;
    }
}
public class ThreadDemo {
    public static void main(String args[]){
        Counter c = new Counter();

        Runnable obj1 = ()->{
            for(int i = 0 ; i < 1000; i++){
//                System.out.println("Hello");
                c.increment();
            }
        };

        Runnable obj2 = ()->{
            for(int i = 0 ; i < 1000; i++){
//                System.out.println("Byy");
                c.increment();
            }
        };

        // there is no start method in runnable interface to start thread execution.
        Thread t1 = new Thread(obj1);  // Thread 1 handling obj1
        Thread t2 = new Thread(obj2);  // Thread 2 handling obj2

        t1.start();
        t2.start();


        // this tasks is job of main thread.
        // it will execute by main thread before the computing the value of c.
        System.out.println(c.count);  // 0


        // i want to wait main thread to compute c.
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        // value is not still 2000 because it might be chance
        // where t1 and t2 got count at same time let say count = 3 then at that moment only
        // one time value of the count will increase;

        // that's why multithreading is not safe some time.
        System.out.println(c.count);

        // to achieve thread safety
        // mean if you want that only thread access one value at time only then
        // you can use synchronize key word

        System.out.println(c.count);


    }
}
