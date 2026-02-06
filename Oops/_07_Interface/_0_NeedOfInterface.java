package Oops._8_Interface;

/**
 *  in interface : methods are by default public abstract.
 *  in interface : variables are by default public static final
 *
 *
 *
 *
 */


interface Computer                  // abstract class
{
    int price = 3000;
    void compileCode();             // by default abstract

    default void config()           // can not call by interface name it is default
    {                               // configuration for computer if you want it to change
                                    // for laptop if you want to change it for desktop then
                                    // you have to override.
        System.out.println("Minimum 8Gb ram needed");
    }
    static void staticMethod(){
        System.out.println("this is static method in computer interface");
    }

}

interface Portable{                  // Interface
    void move();                     // abstract methods
}

class Laptop implements Computer, Portable
{
    public void compileCode()
    {
        System.out.println("you got 5 errors");
    }
    public void move(){
        System.out.println("Laptops are moveable");
    }
    public void config(){
        System.out.println("8Gb ram laptop");
    }
}

class Desktop implements Computer
{
    public void compileCode()
    {
        System.out.println("you got 5 errors, faster");
    }
}

class Developer
{
    public void buildApp(Computer obj)
    {
        System.out.println("Building App");
        obj.compileCode();
    }
}

public class _0_NeedOfInterface {
    public static void main(String[] args) {
        //Laptop obj = new Laptop();
        Computer desks = new Desktop();
        Computer laps = new Laptop();


        Developer dev = new Developer();
        dev.buildApp(laps);

        System.out.println(Computer.price);
//        Computer.price = 40;     // can't do because variables in interface are by default
                                   // public static and final;


        laps.config();
        desks.config();

        Computer.staticMethod();

    }
}