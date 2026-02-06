package Oops._6_Static._5_StaticImport;
import static java.lang.Math.*; // Static import

public class StaticImport {
    public static void main(String[] args) {
        double result = sqrt(25); // No need to use Math.sqrt()
        System.out.println(result); // Output: 5.0
    }
}
