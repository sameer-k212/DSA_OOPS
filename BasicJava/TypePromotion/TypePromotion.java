
public class TypePromotion {
    public static void main(String[] args) {
        int i = 5;
        byte b = 2;
        char ch = '0';
        long l = 40;
        float f = 2.5f;

        float result = i + b + l + ch + f;
        double result1 = i + b + l + f;
//        long result2 = i + b + l + f; // ye default type promotion hoga float me

//        double d = 5;
//        float res = d; // Cannot hold implicitly (double  > float)

        double d = 2.5;
//        long result3 =  i + b + l + d; // default type promotion hoga double me.

        char a = 'a';
        char bb = 'b';
        int result4 = a - bb; // expression default evaluate to the int if not any
                              // data type with higher priority than int.



    }
}
