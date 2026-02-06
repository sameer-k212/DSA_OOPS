package Oops.Threads._2_CreatingThreadViaExtendingThread;

/**
 * Java itself is not inherently single-threaded. While a basic Java program starts with
 * a single "main" thread, Java provides built-in support for multithreading.
 */


// now i want to create a two thread and execute them parallel.



class A extends Thread{
    public void run(){  // "mandatory" to create.
        show();
    }
    public void show()  {
        for(int i = 0 ; i < 50; i++){
            System.out.println("Hyy A");

            // if you want to sleep your thread
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
class B extends Thread{
    public void run(){  // "mandatory" to Create
        show();
    }
    public void show() {
        for (int i = 0; i < 50; i++) {
            System.out.println("Hyy B");

            // if you want to sleep your thread.
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
public class DemoThread {
    public static void main(String[] args) {
        A a = new A();
        B b = new B();

        // you can know what is the priority of the threads
        System.out.println(a.getPriority());

        // by doing this you can set more priority.
        a.setPriority(Thread.MAX_PRIORITY);

        a.start();
        b.start();

    }
}
