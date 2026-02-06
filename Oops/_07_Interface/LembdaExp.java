package Oops._8_Interface;
interface Car1
{
    void drive();
}
public class LembdaExp {
    public static void main(String args[]){
        Car1 obj=()->System.out.println("Driving...");
        obj.drive();
    }
}

