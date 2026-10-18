import java.util.*;
public class Factorial {
    private static final int MAX = 500;

    public static int multiply(int x, int res[], int res_size) {
        int carry = 0;

        for (int i = 0; i < res_size; i++) {
            int prod = res[i] * x + carry;
            res[i] = prod % 10;
            carry = prod / 10;
        }

        while (carry != 0) {
            res[res_size] = carry % 10;
            carry = carry / 10;
            res_size++;
        }
        return res_size;
    }

    public static void factorial(int n) {
        int[] res = new int[MAX];
        res[0] = 1;
        int res_size = 1;

        for (int x = 2; x <= n; x++) {
            res_size = multiply(x, res, res_size);
        }

        // System.out.println("Factorial of given number is");
        for (int i = res_size - 1; i >= 0; i--) {
            System.out.print(res[i]);
        }
        System.out.println();
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int t = scanner.nextInt();

        for (int i = 0; i < t; i++) {
            int n = scanner.nextInt();
            factorial(n);
        }

        scanner.close();
    }
}

