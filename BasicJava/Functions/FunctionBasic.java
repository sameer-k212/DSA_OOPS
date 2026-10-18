// very important;
public class FunctionBasic {
    int b;
   public void main(int c)
    {
        c=90;
        b=c;
    }
    int getValue(){
        return b;
    }
    public void main1(int d)
    {
        d=80;
        b=d;
    }

    public static void main(String args[])
    {
        FunctionBasic f=new FunctionBasic();
        int a=9;
        System.out.println("a:"+a);
        f.main(a);
        f.main1(a);
        System.out.println(f.getValue());
    }
}
