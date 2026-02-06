package Oops._1_Constructor;

class Parent{
    int a,b;
    public Parent(){
        System.out.println("Parent class constructor.");
    }
    public Parent(int x,int y){
        System.out.println("Parameterised parent constructor.");
    }
}
 class Child1 extends Parent{
    int m,n;
    public Child1(){
        System.out.println("Child1 class constructor.");
    }
    public Child1(int x,int y){
        System.out.println("Parameterised Child constructor.");
        m=x;
        n=y;
    }
}


public class Constructor1 {
    public static void main(String[] args) {
        Child1 obj = new Child1();
        Child1 obj1 = new Child1(10,20);
    }
}
