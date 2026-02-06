package Oops._8_Interface;
abstract class Aeroplane{
    abstract public void takeOff();
    abstract public void fly();
    public void landing(){
        System.out.println("Landing");
    }
}
class PassengerPlane extends Aeroplane{
    public void takeOff(){
        System.out.println("PassengerPlane requires medium size run way");
    }
    public void fly(){
        System.out.println("PassengerPlane flies at medium height");
    }
    public void alert(){
        System.out.println("Alert");
    }

}
class CargoPlane extends Aeroplane{
    public void takeOff(){
        System.out.println("CargoPlane requires large size run way");
    }
    public void fly(){
        System.out.println("CargoPlane flies at lower height");
    }
}
public class _1_LaunchAbs {
    public static void main(String[] args) {
        Aeroplane c = new CargoPlane();
        c.takeOff();
        c.fly();
        c.landing();

        System.out.println("------------------------------");

        Aeroplane p=  new PassengerPlane();
        p.takeOff();
        p.fly();
        p.landing();
        System.out.println("------------------------------");
    }
}
