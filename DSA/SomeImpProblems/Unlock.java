package DSA.SomeImpProblems;
import java.util.*;
public class Unlock {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];

        // Read the input permutation
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        // DSA.Hashing.HashMap to keep track of the current index of each number
        HashMap<Integer, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            indexMap.put(arr[i], i);
        }

        // Perform swaps to get the largest permutation
        for (int i = 0; i < n && k > 0; i++) {
            // The value that should be at position i for the largest permutation
            int targetValue = n - i;

            // If the current element is already the target value, continue
            if (arr[i] == targetValue) {
                continue;
            }

            // Get the index of the target value
            int targetIndex = indexMap.get(targetValue);

            // Swap the current element with the target element
            indexMap.put(arr[i], targetIndex);
            indexMap.put(targetValue, i);

            int temp = arr[i];
            arr[i] = arr[targetIndex];
            arr[targetIndex] = temp;

            // Decrease the number of allowed swaps
            k--;
        }

        // Print the final permutation
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}


