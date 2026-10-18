
public class Fibonacci {
    public static void main(String[] args) {
        System.out.println("Fibonacci of 6: " + fibonacci(6));
        System.out.println("First 10 Fibonacci numbers:");
        for (int i = 0; i < 10; i++) {
            System.out.print(fibonacci(i) + " ");
        }
    }

    /**
     * Calculate nth Fibonacci number using recursion
     * @param n position in Fibonacci sequence
     * @return nth Fibonacci number
     */
    public static int fibonacci(int n) {
        if (n < 2) {
            return n;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }
}