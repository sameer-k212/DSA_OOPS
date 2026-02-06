package Oops._8_Interface;
interface A{
    int num = 6;
    void show();
    default void work(){
        System.out.println("This is method of A Interface.");
    }
}
class B implements A{
    public void show(){
        System.out.println("In Show");
    }
    public void work(){
        System.out.println("This is method of B class");
    }
}
public class Intro {
    public static void main(String[] args) {
     //   A obj1 = new A(); // not possible to instantiate.

        B obj = new B();
        obj.show();
        obj.work();


        A obj2 = new B();
        obj2.show();
        obj2.work();

    }
}
