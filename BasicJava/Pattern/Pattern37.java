
public class Pattern37 {
    public static void main(String args[])
    {
        int n=5;
        int i=1;
//        while(i<=n)
//        {
//            int j=1;
//            char ch='A';
//            while(j<=n-i+1)
//            {
//                System.out.print(ch);
//                ch++;
//                j++;
//            }
//            i++;
//            System.out.println();
//        }


//        i=1;
//        while(i<=n)
//        {
//            int j=1;
//            while(j<=n-i+1)
//            {
//                System.out.print((n-j+1));
//                j++;
//            }
//            i++;
//            System.out.println();
//
//        }

        i=1;
        while(i<=n)
        {
            int j =1;
            char ch='E';
            while(j<=i)
            {
                System.out.print(ch);
                ch--;
                j++;
            }
            System.out.println();
            i++;
        }

    }
}
