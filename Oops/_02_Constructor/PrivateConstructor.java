package Oops._1_Constructor;

public class PrivateConstructor {
    public static PrivateConstructor obj= new PrivateConstructor();

    private PrivateConstructor(){

    }

    public static PrivateConstructor getObj(){
        return obj;
    }

    public static void main(String[] args) {
        System.out.println(getObj());
    }
}
