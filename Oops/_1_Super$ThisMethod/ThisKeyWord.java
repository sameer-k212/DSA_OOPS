

class Hello{
    String str = "hello";
    Hello(String s){
        this.str = s;
        System.out.println("this - > " + this);
    }
}
public class ThisKeyWord {
    public static void main(String args[]){
        Hello obj = new Hello("Sameer");
    }
}
