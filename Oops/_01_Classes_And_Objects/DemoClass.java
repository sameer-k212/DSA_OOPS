package Oops._0_Classes$Object;
/*
   FOR STATIC AREA

** there are three method to call a static method or static variable

1. without creating an object.
2. by creating an object.
3. by class name.

   FOR INSTANCE AREA

1. By creating an only object.

*/

public class DemoClass {
    int n = 4;
    static int m = 45;
    String name = "sameer";

    public static void M1() {
        double a=90;
        double b=23;
        System.out.println(DemoClass.m);
        M1(a,b);
    }

    public static double M1(double a, double b) {
        a = 90;
        b = 98;
        double s=a+b;
        System.out.println(s);
        System.out.println(m);
        return 2;
    }
    public static void main(String args[])
    {
        DemoClass obj=new DemoClass();
        obj.M1();
        System.out.println(obj.name);
        System.out.println(m);
    }
}

class Main{
    public static void main(String[] args) {
        DemoClass.M1();
    }
}
