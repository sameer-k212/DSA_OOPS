package Oops.Wrapper;

public class Wrapper {
    public static void main(String[] args) {

        int a =20;
        Integer a1 = a;  // autoboxing
        String str = String.valueOf(a1);
        System.out.println(str);

        Integer val = 10;
        int c = val;  // autoUnboxing

        String str1 = "10";
        Integer in = Integer.valueOf(str);
        int b = in;
        System.out.println(in);


        Integer x = 5;
        // Convert int to byte and return a primitive data type byte
        System.out.println (x.byteValue ());

        // Converts an int to double and returns a primitive data type double
        System.out.println (x.doubleValue ());

        // Convert int to long and returns a primitive data type long
        System.out.println (x.longValue ());

    }
}
