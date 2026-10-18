//The instance variables, constructor, and method names can appear in
//        any order within a class declaration.

//11.Which type can fill in the blank?
//        pi = 3.14;
//        A. byte
//        B. float
//        C. double
//        D. short
//        C. Options A and D are incorrect because byte and short do not store
//        values with deci-mal points. Option B is tempting. However, 3.14 is
//        automatically a double. It requires casting to float or writing 3.14f
//        in order to be assigned to a float. Therefore, Option C is correct.


public class BasicOne{
    public static void main(String args[]){
        System.out.println(2%10);// 2
        System.out.println(3*7+4*.18);
        char a='a';
        System.out.println(a); // it will not return an integer value.
        System.out.println(a+10); // type promotion
        System.out.println((float)a); // type casting.
        char b='1';
        System.out.println(b+1);
        int $=5;
        System.out.println($);
        System.out.println((double)(12/5));
        System.out.println(0%10);
        System.out.println();

        double d1 = 5f; // p1
        double d2 = 5.0; // p2
        float f1 = 5f; // p3
        System.out.println(4%4);
       // float f2 = 5.0; // p4 it will cause error.


        // let me sout you some thing interesting.
        System.out.println("hello new output:");
        int A='1';
        System.out.println(A); // 49
                               // If you assign a char value to an int variable,
                               // the compiler automatically converts the char value to
                               // an int value through
                               // implicit type casting
        System.out.println('A'); // A // here we are not doing any type casting
        System.out.println('A'+A); // 114 // here type promotion
        System.out.println("A"+A); //A49 // string +int = concatinate.
                                   // type promotion in higher data type

        System.out.println("A"+'A'); // AA // type promotion in higher data type.


        System.out.println("Another thing:");
        char ch='a';

        System.out.println(ch); // 'a' // nothing happend to them.
        System.out.println(ch+"a"); // aa // type promotion.

        System.out.println(ch+2); // char + int = int . type promotion.
        System.out.println("a"+ch+1);// aa1 // compiler move from left to right.
                                        // string + char = string, string + int
                                        // = string;
        System.out.println('a'+ch);// /194 // type promotion // expression must be
                                        // evaluated to int
        System.out.println('a'+ch+1);// 195 // type promotion char + char + int = int
        System.out.println('a'+ch+"a"+'a');// 194aa

        String s1 = "Sameer";
        StringBuilder str = new StringBuilder(s1);
        String ch1 = ""+str.charAt(0);
        String ch2 = ""+str.charAt(s1.length()-1);
        str.replace(0,1,ch2);
        str.replace(s1.length()-1,s1.length(),ch1);
        System.out.println(str);


        System.out.println(('z'+'0') == 'a');
//        int val = 'a';
//        char ch4 = 'z'+1;
//        System.out.println(ch4);
//        System.out.println(val);

        int j = 0;
        String s = "abaacbcbb";
        int k = s.length();
        System.out.println(s.substring(0,j+1) + s.substring(j+1,k) + s.substring(k));




    }
}


