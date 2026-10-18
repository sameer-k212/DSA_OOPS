
public class SumOfDigits {
    public static void main(String[] args) {
        System.out.println("Sum of digits of 1234: " + sumOfDigits(1234));
        System.out.println("Sum of digits of 9876: " + sumOfDigits(9876));
        System.out.println("Sum of digits of 0: " + sumOfDigits(0));
    }

    /**
     * Calculate sum of digits of a number using recursion
     * @param n the number
     * @return sum of all digits in n
     */
    public static int sumOfDigits(int n) {
        if (n == 0) {
            return 0;
        }
        return (n % 10) + sumOfDigits(n / 10);
    }
}