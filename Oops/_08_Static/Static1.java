package Oops._6_Static;
class basic4
{
    static int m;
    {
        System.out.println(m);
    }
    static void main1()
    {
        System.out.println("main1");
    }

}

public class Static1
{
    static int n=9;
    static
    {
        System.out.println(n);
    }
    {
        System.out.println(n);
    }
    static void main2()
    {
        System.out.println("main2");
    }
    public static void main(String args[]) {
        main2();
        basic4.main1();

    }
}
