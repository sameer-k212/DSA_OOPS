package DSA.zSomeImpProblems;
import java.util.*;
public class Array_Intersection {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read size of the arrays
        int N = scanner.nextInt();

        // Read the first array
        int[] arr1 = new int[N];
        for (int i = 0; i < N; i++) {
            arr1[i] = scanner.nextInt();
        }

        // Read the second array
        int[] arr2 = new int[N];
        for (int i = 0; i < N; i++) {
            arr2[i] = scanner.nextInt();
        }

        // Get intersection
        List<Integer> intersection = getIntersection(arr1, arr2);

        // Print the result
        System.out.println(intersection);

        scanner.close();
    }

    public static List<Integer> getIntersection(int[] arr1, int[] arr2) {
        List<Integer> resultList = new ArrayList<>();

        // Sort both arrays
        Arrays.sort(arr1);
        Arrays.sort(arr2);

        // Pointers for both arrays
        int i = 0, j = 0;

        // Find common elements
        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] < arr2[j]) {
                i++;
            } else if (arr1[i] > arr2[j]) {
                j++;
            } else {
                // When they are equal, add to the result
                resultList.add(arr1[i]);
                i++;
                j++;
            }
        }

        return resultList;
    }
}
