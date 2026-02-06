package Oops._8_Interface.FunctionalInterface;

/**
 * Functional Interface : a functional interface has exactly one abstract method. Since
 * default methods have an implementation, they are not abstract.
 *
 * If an interface declares an abstract method overriding one of the public methods of
 * java.lang.Object, that also does not count toward the interface's abstract method count
 * since any implementation of the interface will have an implementation from java.lang.Object
 * or elsewhere.
 */


@FunctionalInterface
interface MyFunctionalInterface {
    void performAction(); // The single abstract method
}

public class FunctionalInterfaceExample {
    public static void main(String[] args) {
        // Using a lambda expression to implement the functional interface
        MyFunctionalInterface action = () -> System.out.println("Action performed!");
        action.performAction();
    }
}