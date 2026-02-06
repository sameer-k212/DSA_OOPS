package Oops._3_Polymorphism.MethodOverriding;
// runtime pe hota hain (Dynamic Polymorphism)
class Aeroplane{
    public void takeOff(){
        System.out.println("Aeroplane is taking off");
    }
    public void fly(){
        System.out.println("Aeroplane is flying");
    }
    public void land(){
        System.out.println("Landing Compulsory");
    }
}
class CargoPlane extends Aeroplane{
    public void takeOff(){
        System.out.println("Cargo Plane requires longer run way");
    }
    public void fly(){
        System.out.println("CargoPlane flies at lower height");
    }

}
class PassengerPlane extends Aeroplane{
    public void takeOff(){
        System.out.println("PassengerPlane requires medium run way.");
    }
    public void fly(){
        System.out.println("PassengerPlane flies at medium height.");
    }
}

public class Overriding {
    public void read(){
        System.out.println("child read");
    }
    public static void main(String[] args) {
        CargoPlane cp = new CargoPlane();
        PassengerPlane pp = new PassengerPlane();

        cp.takeOff(); //
        cp.takeOff(); //
        cp.land();

        System.out.println("----------------------------------------------------------");

        pp.fly(); //
        pp.takeOff(); //

        System.out.println("------------------------------Verification of Method overriding----------------------------");

        Aeroplane A;

        // assigning ref of cp
        A = cp;
        A.fly();
        A.land();
    }
}
