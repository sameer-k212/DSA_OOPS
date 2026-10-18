
import java.util.Arrays;

public class stringBaisc {


    static int i = 0;
    public static void main(String args[])
    {
        int i =9;
        System.out.println(i);
        String s1="Sameer";
        String s2="Sameer";

        StringBuilder str1 = new StringBuilder(s1.substring(0,2));
        StringBuilder str2 = new StringBuilder(s1.substring(2));
        String str = new String(str1+""+str2);

        System.out.println(str);
//        StringBuilder str = new StringBuilder(s1);
//        str.reverse();
//        System.out.println(str);


//        System.out.println(s1==s2); // false because only in case of string it
                                       // references not value.
//        System.out.println(s1.charAt(0)==s2.charAt(0));

//        String  s3=s2;
//        System.out.println(s3);


//      s3=s1.charAt(1); // it will through error because charAt method return char.

//        char ch=s1.charAt(1);
//        s3="Sameer";
//        System.out.println(ch+s3); // type promotion.

//        String str[]= s1.split("");


//        System.out.println(str[3]==str[4]);
//        System.out.println(str[3].equals(str[4]));

//        char char_Array[]=s1.toCharArray();
//        System.out.println(char_Array[3]==char_Array[4]);// there is no .equal method
//
//        System.out.println(s3.charAt(3)==s3.charAt(4)); // true because here is not

        // string comparison. here we are comparing charecter at index.
//
//        str[3]=null;
//        System.out.println(str[3]==null); // because one don't have reference.




    }

}
