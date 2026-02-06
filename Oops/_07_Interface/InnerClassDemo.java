package Oops._8_Interface;

// inner class - Member, static and Anonymous

class Address{
    String city;
    String state;    // if you want to use these data into another class then you can do (Address add).
    int pinCode;    // or use inner class to use this clas because there is no rest use of this class.
}

class Z{                   // we can not use static key word for outer class.
    public void show(){
        System.out.println("in show");
    }
    class B{         // member inner class
        public void display(){
            System.out.println("in display");
        }
    }
}
public class InnerClassDemo {
    public static void main(String[] args) {
        Z obj = new Z();
        obj.show();

        Z.B obj1 = obj.new B();   // if there is an static inner class(static class B) then we
                                  // can use only class name like : Z.B obj1 = new Z.B();
        obj1.display();


    }

}
