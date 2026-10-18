
public class Factorial {
    public static void main(String[] args) {
        System.out.println("Factorial of 5: " + factorial(5));
        System.out.println("Factorial of 0: " + factorial(0));
    }

    /**
     * Calculate factorial of a number using recursion
     * @param n the number to calculate factorial for
     * @return factorial of n
     */
    public static int factorial(int n) {
        if (n <= 1) {
            return 1;
        }
        return n * factorial(n - 1);
    }
}