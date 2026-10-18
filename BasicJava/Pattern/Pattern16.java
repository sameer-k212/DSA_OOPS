
import java.util.Scanner;

public class Pattern16 {
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        System.out.print("n:");
        int n = scan.nextInt();
        int row=1;
        while(row<=n)
        {
            int colmn =1;
            while(colmn<=n)
            {
                if(row==1 || row==((n-1)/2+1) || row==n || row+colmn==n+1)
                {
                    System.out.print("* ");
                }
                else
                {
                    System.out.print("  ");
                }
                colmn+=1;
            }
            row+=1;
            System.out.println();
        }
    }
}
