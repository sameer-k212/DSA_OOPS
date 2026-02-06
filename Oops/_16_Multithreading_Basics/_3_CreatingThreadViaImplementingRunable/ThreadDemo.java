package Oops.Threads._3_CreatingThreadViaImplementingRunable;

/**
 *                         |
 *                         |
 *            -----------------------------
 *            \             \              \
 *            \              \             \
 *        Thread t1      Main Thread    Thread t2
 *
 */




class A implements Runnable{
    public void run(){  // "mandatory" to create.
        for(int i = 0 ; i < 500; i++){
            System.out.println("Hyy A");
        }
    }
}
class B implements Runnable{
    public void run(){  // "mandatory" to Create
        for (int i = 0; i < 50; i++) {
            System.out.println("Hyy B");
        }
    }
}
public class ThreadDemo {
    public static void main(String[] args) {
        A a = new A();
        B b = new B();

        // in runnable there is only run method. but threads are start using start.
        Thread t1 = new Thread(a);
        Thread t2 = new Thread(b);

        t1.start(); // by thread t1
        t2.start(); // by the thread t2


        // in between t1 and t2 of context switching main thread will print this.
        System.out.println("Byy"); // main thread didn't stop while t1 and t2 is executing.
    }
}
