
public class ReverseNumber {
    public static void main(String[] args) {
        System.out.println("Reverse of 1234: " + reverseNumber(1234, 0));
        System.out.println("Reverse of 9876: " + reverseNumber(9876, 0));
        System.out.println("Reverse of 100: " + reverseNumber(100, 0));
    }

    /**
     * Reverse a number using recursion
     * @param n the number to reverse
     * @param reversed the accumulated reversed number
     * @return reversed number
     */
    public static int reverseNumber(int n, int reversed) {
        if (n == 0) {
            return reversed;
        }
        return reverseNumber(n / 10, reversed * 10 + n % 10);
    }
}