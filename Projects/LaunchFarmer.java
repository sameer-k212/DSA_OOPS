
import java.util.Scanner;

class Farmer
{
    int principle_amount;
    float time_duration;
    //float rate_of_intrust;
    // for more efficient we will make it static.
     static float rate_of_intrust;
     static
     {
         rate_of_intrust=8.5f;
     }
    float simple_intrust;

    void input()
    {
        Scanner scan=new Scanner(System.in);
        System.out.println("please mention the amnout required:");
        principle_amount=scan.nextInt();
        System.out.println("Please mention time duration:");
        time_duration=scan.nextFloat();
    }
    void compute()
    {
        simple_intrust=(principle_amount*time_duration*rate_of_intrust)/100f;
    }
    void display()
    {
        System.out.println("simple intrust is: "+simple_intrust);
    }
}

public class LaunchFarmer {
    public static void main(String args[])
    {
        Farmer f1=new Farmer();
        f1.input();
        f1.compute();
        f1.display();
        Farmer f2=new Farmer();
        f2.input();
        f2.compute();
        f2.display();


    }
}
