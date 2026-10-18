
public class Pattern38 {
    public static void main(String args[])
    {
        int i=1;
        int n=5;
        while(i<=n)
        {
            int j=1;
            while(j<=n-i)
            {
                System.out.print(" ");
                j++;
            }
                j=1;
                char ch='A';
                while(j<=2*i-1)
                {
                    System.out.print(ch);
                    if(j<(2*i+1)/2)
                    {
                        ch++;
                    }
                    else
                    {
                        ch--;

                    }
                    j++;
                }
                i++;
                System.out.println();
            }
        }
    }

