
import java.util.Scanner;

public class Pattern27 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of rows (even number): ");
        int n = sc.nextInt();
        sc.close();

        if (n % 2 == 0) {
            printDiamondPattern(n);
        } else {
            System.out.println("Please enter an even number of rows.");
        }
    }

    public static void printDiamondPattern(int rows) {
        int spaces = rows / 2;
        int stars = 1;

        // Upper half of the diamond
        for (int i = 1; i <= rows / 2; i++) {
            for (int j = 1; j <= spaces; j++) {
                System.out.print(" ");
            }

            for (int j = 1; j <= stars; j++) {
                System.out.print("*");
            }

            System.out.println();
            spaces--;
            stars += 2;
        }

        // Lower half of the diamond
        spaces = 1;
        stars = rows - 2;

        for (int i = rows / 2; i >= 1; i--) {
            for (int j = 1; j <= spaces; j++) {
                System.out.print(" ");
            }

            for (int j = 1; j <= stars; j++) {
                System.out.print("*");
            }

            System.out.println();
            spaces++;
            stars -= 2;
        }
    }
}