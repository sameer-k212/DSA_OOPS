package Oops._8_Interface;

interface Car{       // interface is a concept (car is a concept)
    int a = 7;
    void drive();
    static void data(){ // we can give body to interface method using static only.
        System.out.println("Hello");
    }
//    The method belongs to the interface itself, not to the implementing class — and
//    therefore it can have a body (definition).
}
interface Bus{
    void drive();
}

class Wagnor implements Car, Bus{
    public void drive(){
        System.out.println("Driving..");
    }
    static void data(){
        System.out.println("I am new to here");
    }

}

public class AnonymousInnerClass {

    public static void main(String[] args) {
        Bus obj = new Wagnor();
        obj.drive();
    }
}
