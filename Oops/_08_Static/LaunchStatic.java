package Oops._6_Static;

public class LaunchStatic {

    // area of declearation not printing.
    static int age;
    int age1=19;
    static{
        LaunchStatic obj=new LaunchStatic();
        age=18;
        System.out.println(age);
        System.out.println("First exicute static block.");
        System.out.println(obj.age1);
    }
    static
    {
        age=90;
    }

    static void Display()
    {
        System.out.println("Staic display method");
        // it will exicute after main when we call.
    }
    public static void main(String args[])
    {
        // creating an object to access instance variable in static area
        LaunchStatic obj=new LaunchStatic();

        // static method
        String name="sameer";
        System.out.println(name);

        System.out.println("Second exicute static method.");

        //instatce variable
        System.out.println(obj.age1);

        // static variable
        System.out.println(age);

        // calling static method : here we need to call all static methods.
        // static block and static variable will exicute at class loading. by default.
        Display();
    }
}
