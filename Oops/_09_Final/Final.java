package Oops._7_FinalKeyWord;

// A final method inherit in child class but can not be overide.
// A class is marked as final then the class won't participate in inheritance.

class parent1{
    final int a=0; // A final variable must be initialize.
    final void work(){
       //  a=9; value of final variable can not be changed further, initialize onece.
        // even in final method can not be changed.
        System.out.println("New Work1");
    }
    void work1(){
       // a=9;
        System.out.println("Work1");
    }
}
class child1 extends parent1{
    void mywork(){
        System.out.println("My Work1");
    }
}

public class Final{
    public static void main(String args[]){
        parent1 obj = new parent1();
        obj.work();
        System.out.println(obj.a);
    }

}
