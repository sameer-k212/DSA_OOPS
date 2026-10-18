
public class ReverseInteger {
    public static void main(String args[]){
//        int value = -120;
//        boolean bool  = value>0?true:false;
//        String str = ""+BasicJava.Math.abs(value);
//        StringBuilder str1 = new StringBuilder(str);
//        str1.reverse();
//
//        System.out.println(str1);
        int x = 521;
        int sum = 0;
        while(Math.abs(x) != 0){
            int rem = x % 10;
            sum = sum * 10 + rem;
            x = x / 10;
        }
        System.out.println(sum);
//        System.out.println(Integer.MIN_VALUE);
    }
}
