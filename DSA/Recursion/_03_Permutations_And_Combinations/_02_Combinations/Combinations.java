
import java.util.ArrayList;
import java.util.List;

public class Combinations {
    public static void main(String[] args) {
        List<List<Integer>> result1 = new ArrayList<>();
        combinationsArray(new int[]{1, 2, 3, 4}, 3, 0, new ArrayList<>(), result1);
        System.out.println("Combinations of size 3 from [1,2,3,4]: " + result1);
        
        List<List<Integer>> result2 = new ArrayList<>();
        combinationsNumbers(4, 2, 1, new ArrayList<>(), result2);
        System.out.println("Choose 2 from numbers 1 to 4: " + result2);
    }

    public static void combinationsArray(int[] arr, int k, int start, List<Integer> current, List<List<Integer>> result) {
        if (current.size() == k) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int i = start; i < arr.length; i++) {
            current.add(arr[i]);
            combinationsArray(arr, k, i + 1, current, result);
            current.remove(current.size() - 1);
        }
    }

    public static void combinationsNumbers(int n, int k, int start, List<Integer> current, List<List<Integer>> result) {
        if (current.size() == k) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int i = start; i <= n; i++) {
            current.add(i);
            combinationsNumbers(n, k, i + 1, current, result);
            current.remove(current.size() - 1);
        }
    }
}