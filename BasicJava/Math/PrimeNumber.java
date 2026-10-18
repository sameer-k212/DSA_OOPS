
public class PrimeNumber {
    static boolean Prime(int n)
    {
        boolean prime=true;

        for(int i=2;i<n;i++)
        {
            if(n%i==0)
            {
                prime=false;
            }
        }
        return prime;
    }
    public static void main(String agrgs[]){
        int n=2;
        int m=3;
        int mn=n;
        int next_prime=n;
        while(++mn!=0){
            boolean result = Prime(mn);
            if(result == true){
                next_prime=mn;
                break;
            }
        }
        if(m==next_prime && next_prime!=n){
            System.out.println("YES");
        }
        else{
            System.out.println("NO");
        }
    }
}
