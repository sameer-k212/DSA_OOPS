
public class Pattern20 {
    public static void main(String[] args) {
          int n=5;
//        int i=1;
//        while(i<=n)
//        {
//            int j=1;
//            while(j<=n)
//            {
//                if(i==n || j==n || i+j>=(n+1))
//                {
//                    System.out.print("*");
//                }
//                else
//                {
//                    System.out.print(" ");
//                }
//                j++;
//            }
//            i++;
//            System.out.println();
//
//        }
        for(int i=1;i<=n;i++)
        {
            for(int space=1;space<=n-i;space++)
            {
                System.out.print(" ");
            }
            for(int star=1;star<=i;star++)
            {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
