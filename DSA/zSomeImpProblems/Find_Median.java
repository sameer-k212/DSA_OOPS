package DSA.SomeImpProblems;
import java.util.*;

public class Find_Median {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt(); // Number of test cases

        for (int i = 0; i < t; i++) {
            int n = sc.nextInt(); // Number of elements in the array
            int arr[] = new int[n];
            for (int k = 0; k < n; k++) {
                arr[k] = sc.nextInt(); // Input elements
            }

            // Use a list to maintain order and calculate median
            List<Integer> list = new ArrayList<>();

            for (int j = 0; j < arr.length; j++) {
                list.add(arr[j]);
                Collections.sort(list); // Sort the list after each addition

                // Calculate median
                if (list.size() % 2 == 0) {
                    // Even size
                    int median = (list.get((list.size() / 2) - 1) + list.get(list.size() / 2)) / 2;
                    System.out.print(median + " "); // Print the median
                } else {
                    // Odd size
                    System.out.print(list.get(list.size() / 2) + " "); // Print the median
                }
            }
            System.out.println(); // New line for the next test case
        }
        sc.close(); // Close the scanner
    }
}
