package Oops._1_Constructor;
class Demo{
    String new_name;
    Demo(String new_name){
        this(); // this will call the constructor of the class this is referring to.
      //   this.name=name; there is no instance "name" variable so that it will show error.
      this.new_name =new_name;
        System.out.println("String perametrise : "+ new_name);
    }
    Demo(){
        System.out.println("non Peramiterise");
    }
}


public class ThisAndSuper {
    public static void main(String[] args) {
        String name = "sameer";
        Demo d = new Demo(name);

        int data = 3;
//        System.out.println( data instanceof Object);
    }
}
