
public class Pattern19 {
    public static void main(String[] args) {
        int n=5;
        int i=0;
        while(i<n)
        {
            int j=0;
            while(j<n)
            {
                if(i==0&&j==0 || j==0&&i<n ||i==n-1&&j<n || i>=j)
                {
                    System.out.print("*");
                }

                j++;
            }
            i++;
            System.out.println();
        }

    }
}
