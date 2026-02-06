package Oops._0_Classes$Object;

class Parent{
    void walk(){
        System.out.println("Parent Walk For 5km Daily Evening");
    }
    void sleep(){
        System.out.println("Parent Sleep For 6 Hours");
    }
    void officeWork(){
        System.out.println("Parent Went Office For 9am to 5pm");
    }
}
class Child extends Parent{
    void walk(){
        System.out.println("Child Walk For 2km Daily Morning");
    }
    void schoolWork(){
        System.out.println("Child Went For School 8am to 2pm Work");
    }
}


public class Class$Object extends Parent {
    public static void main(String[] args) {
        Parent p = new Parent();
//        p.schoolWork();   it will throw error  and say create schoolWork() to Parent class.

        p.walk(); // parent thing


        Parent P = new Child();
//        P.schoolWork(); // it will throw error  and say create schoolWork() to Parent class.
        P.walk(); // it will give child thing.
        // if any method is present in parent and child extend that thing and
        // we are calling with parent reference and child object so child thing
//         will be printed.


//        Child c1 = new Parent(); Can't Hold.
        Child c = new Child();




    }
}
