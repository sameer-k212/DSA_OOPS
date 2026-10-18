
public class Pattern36 {
    public static void main(String args[])
    {
        int n=5;
        int i=1;
        char ch1='F';
        while(i<=n){
            int j=1;
            char ch='A';
            while(j<=i)
            {
                System.out.print(ch);
                ch++;
                j++;
            }
            i++;
            System.out.println();
        }

    }

}
