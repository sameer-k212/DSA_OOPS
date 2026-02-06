package Oops.Threads._1_MainThread;

// Default we have Main thread.
class A{
    public void show(){
        for(int i = 0 ; i < 5; i++){
            System.out.println("Hyy A");
        }
    }
}
class B{
    public void show(){


        for(int i = 0 ; i < 5; i++){
            System.out.println("Hyy B");
        }
    }
}
public class Demo {
    public static void main(String[] args)
     { // Main thread start from here and start executing all the statements in this method;
        A a = new A(); // main thread created Object of A
        a.show();//calling show method of A, Main thread goes to class A to execute show method

        B b = new B(); // after that method execution thread will reach here and create obj B
        b.show(); // and same as.....
    }
}
