package Oops.Multithreading;

/**
 * yield(): Thread.yield() is a static method that suggests the current thread temporarily
 * pause its execution to allow other threads of the same or higher priority to execute.
 */

public class YeldMethod {
    public static void main(String[] args) {

    }
}
/**
public class MyThread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getName() + " is running...");
            Thread.yield();
        }
    }

    public static void main(String[] args) {
        MyThread t1 = new MyThread();
        MyThread t2 = new MyThread();
        t1.start();
        t2.start();
    }
}

 */