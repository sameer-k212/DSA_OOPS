package Oops._6_Static;
class Demo
{
    static int a=45;
    int b=90;
    static void disp1()
    {
        System.out.println("static void disp1.");
        System.out.println(Demo.a);
    }
    void disp2()
    {
        System.out.println("non static diap2");
        System.out.println(Demo.a);
        System.out.println(b);
    }
}
public class Launch {
    public static void main(String args[])
    {
        // calling by call name of related method. because it is static method.
        // no need to creat objcect for staic method because it is related to class not
        // class instance.
        Demo.disp1();

        // calling by object for non static method of related class.
        Demo d=new Demo();
        d.disp2();
        System.out.println(Demo.a);
    }
}
