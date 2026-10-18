/*

type casting.   {destination type > source type}
1. explicitly type casting
2. implicitly type casting

*/

class BasicTwo {
    public static void main(String args[]) {
        byte s = 12;
        int m;
        m = s;   // no error because we are going  through low to high.

        int a = 13;
        byte c;
        //       c=a;        it will throw error because int have big memorry size as complare to byte.

        long x = 100l;
        int n;
        //      n=x;   it will throw error because long have big memorry size as compare to int

        long y = 10000L;
        float b;
        b = x;        // it is valid float can expand with larger size data type.

        int i = 12;
        int j = 5;
        System.out.println((float) (i / j));   //int type output because operands is intreger type. 2

        float o = 12;
        float p = 5;
        System.out.println(o / p);   // float type out because operand is float type.  2.4

        int q = 12;
        float r = 5;
        System.out.println(q / r);  // float type output because one of the operend is float. 2.4

        int t = 12;
        int u = 5;
        float v = t / u;
        System.out.println(v);   // float but not complete value divison of two integer it gives int and
        // we tyep cast implicitly into float.


        /* type promotion in java
         */

        int ab = 23;
        float bc = 34f;
        long cd = 22l;
        char de = 34;
        double ef = 54;
        System.out.println((byte) (ab + bc + cd + de + ef));// output in  byte because we use type
        // casting otherwise it gives double

        char ch1 = 'a';
        char ch2 = 'b';
        //      byte ch3=ch1+ch2;    // it will throw error just because of expression evaluated to the int.
        System.out.println((long) (ch1 - ch2 + 1)); //  -1


        byte mn = 5;

        mn++;       // not in case of increment decrement.
        byte im = 5;
//        im=im+1;    // error because expression must be evaluatd to the int.


        double mj = 34.3d;
        mj = mj * 5;
        System.out.println(mj);
        int mo;
        mo = (int) mj;
        System.out.println(mo);

        byte no = 5;
        no++;
        System.out.println(no);
        no += 1;  // it is valid not error.
        no *= 7;  // it is valid not error.
        //      no=no+1;    here you will get error. becaus expression evaluate to a int.

        int x_;
//        System.out.println(x_);       it will cause error.

        System.out.println(10 % 10);

        float yu = 9.766f;
        double dx = 2.33D;
        int bn = (int) yu;

        System.out.println(bn);

    }
}

