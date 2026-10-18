
// Data types

import java.util.Arrays;
import java.util.Scanner;

public class Basic3 {
    public static void main(String args[])
    {
        System.out.println(Math.max(-8,-9));
        int a=4;
        int b=8;
        boolean x= a==b;
        System.out.println(x);  // false

        boolean y=true;
        System.out.println(!y); // false

        String s="sameer";
        String s1="sameer";
        if(s==s1)
        {
            System.out.println(true);
        }
        int m=1;
        for(int i=0;i<4;i++)
        {
            m++;
        }
        System.out.println(m);
//
//        System.out.println((int)BasicJava.Math.pow(10,2));
//        Scanner sc = new Scanner(System.in);
//        for(int j = 0 ; j < 1; j++){
//            String str = sc.nextLine();
//            StringBuilder str1 = new StringBuilder(str);
//            for(int i = 0; i < str1.length(); i++){
//                if(str1.charAt(i) == 'p' && str1.charAt(i+1) == 'i'){
//                    str1.replace(i,i+2,"3.14");
//                }
//            }
//            System.out.println(str1);
//        }
       char ch[] = { 'd','c'};
        Arrays.sort(ch);
        System.out.println(Arrays.toString(ch));



        String word = "Sameer";
        String str = word.substring(0,3);
        System.out.println(str.subSequence(0,3));




    }
    public int minBitFlips(int start, int goal) { // start = 10 , goal = 7
        int val = start ^ goal; // 13
        String str1 = Integer.toBinaryString(val); // conversion to binary
        int count = 0;
        for(int i = 0; i < str1.length(); i++){
            if(str1.charAt(i) == '1'){
                count++;            // counting fliped bit
            }
        }
        return count;
    }
}