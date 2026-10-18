
class Parent extends Object{
    long rollNo;
    String name;
    Parent(){  // there is default super() method to call.
        rollNo = 2115001565;
        name = "Sameer Kushwaha";
        System.out.println("Roll NO: " + rollNo + "Name : " + name);
    }

    Parent(int rollNo, String name){
        this.name = name;
        this.rollNo = rollNo;
    }

}
class Child extends Parent{
    long rollNo;
    String name;
    Child(){ // there is default super() method to call.
//        super();
        this(0, null);

        rollNo = 59;
        name = "Nitin Kushwaha";
        System.out.println("Roll No : " + rollNo + "Name : " + name);
    }
    Child(int rollNo, String name){

        this.name = name;
        this.rollNo = rollNo;

        System.out.println("Roll No : " + rollNo + "Name : " + name);
    }

}

public class SuperThis {
    public static void main(String[] args) {
        Child p = new Child();

    }
}
