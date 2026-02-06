package Oops._8_Interface;
interface D{
    void show();
}
interface E{
    void abc();
}
class C implements E,D
{
    public void show(){
        System.out.println("In Show");
    }
    public void abc(){
        System.out.println("abc");
    }
}
public class MultipleInterface {
    public static void main(String[] args) {
        D obj = new C();
        obj.show();
        System.out.println("------------------------");
       // obj.abc(); i can not hold method of interface B with object of C with A type.
        E obj1 = new C();
        obj1.abc();
    }
}

