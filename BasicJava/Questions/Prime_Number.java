import java.util.*;
public class Prime_Number {
    public static void main(String[] args) {
        int n = 144;
        int count  = 0;
        boolean bool = false;
        for(int i = 2; i*i <= n; i++){
            if(n % i == 0){
                bool = true;
                System.out.println("NotPrime");
                break;
            }
        }
        if(!bool){
            System.out.println("Prime");
        }
    }
    // generate Prime numbers
    public static ArrayList<Integer> getPrimeFactors(int n) {
        // Declare an ArrayList to store
        // the prime factors of n.
        ArrayList<Integer> primeFactors = new ArrayList<>();

        // Loop from 2 up to n
        for (int i = 2; i <= n; i++) {
            // Check if n is divisible by i
            if (n % i == 0) {
                // If divisible, add i to
                // the primeFactors ArrayList
                primeFactors.add(i);
            }
            // Continue dividing n by i
            // until it's no longer divisible
            while (n % i == 0) {
                n = n / i;
            }
        }
        // Return the ArrayList
        // containing the prime factors of n.
        return primeFactors;
    }
}
