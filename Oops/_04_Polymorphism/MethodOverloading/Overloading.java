package Oops._3_Polymorphism.MethodOverloading;
// compile time pe hota hain. (Static polymorphism)

public class Overloading {
    public static void method1(){
        System.out.println("Hello This is method  with no parameter");
    }

    public static void method1(int val){
        System.out.println("Hello This is method with one parameter");
    }

    public void method1(int val, String name){
        System.out.println("This is method with two parameter");
    }
    public static void main(String[] args) {

    }
}
