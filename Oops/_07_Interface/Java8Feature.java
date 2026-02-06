package Oops._8_Interface;
interface Animal{
    void sleep(); // must implement
    static void run(){  // this is only belong to this interface. can not be override
        System.out.println("Animal Run faster than human");
    }
    default void cry(){  // can be override
        System.out.println("animal Can Shout");
    }
}
interface Human{
    void sleep(); // must implement
    void cry();   // must implement
    static void work() {  // this is only belong to the Human interface.
        System.out.println("Humans Can Work");
    }
}
class Rohan implements Human{
    public void sleep(){
        System.out.println("Sleeps for 7-8 hours");
    }
    public void cry(){  // Optional: can override cry()
        System.out.println("Human can shouts");
    }
    public void work(){
        System.out.println("Rohan Can work");
    }
}
class Dog implements Animal{
    public void sleep(){ // we have to use access modifier in non-decrease order of visibility
        System.out.println("Dog Sleep for 2 hours only.");
    }
    public void run(){
        System.out.println("Dog runs faster than suraj.");
    }
    public void cry(){  // it will be over ride.
        System.out.println("Dog can bark");
    }
}

public class Java8Feature {
    public static void main(String[] args) {
//      Animal obj1 = new Animal();  // get error because can not instantiate an interface

        Animal obj2 = new Dog();  // can on
        obj2.sleep();
//      obj2.run();   // in dog call run is only belong to dog.
        obj2.cry();   // can be called




//      Animal.cry();  // ❌ Compilation error: cannot call default method this way
        Animal.run();  // static hain toh call ho jayega.
    }
}
