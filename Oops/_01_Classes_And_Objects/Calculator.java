package Oops._0_Classes$Object;
 class calc{
    public int add(int n,int m)
    {
        return n+m;
    }
    public int add(int n1,int n2,int n3)
    {
        return n1+n2+n3;
    }
    public double add(double n1,double n2,double n3)
    {
        return n1+n2+n3;
    }
}
public class Calculator
{
    public static void main(String args[])
    {
        calc obj=new calc();
        int result=obj.add(3,4,5);
        System.out.println(result);

    }
}