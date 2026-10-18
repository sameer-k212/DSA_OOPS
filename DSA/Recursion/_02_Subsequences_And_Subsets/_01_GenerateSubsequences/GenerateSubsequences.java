
import java.util.ArrayList;
import java.util.List;

public class GenerateSubsequences {
    public static void main(String[] args) {
        List<String> result = new ArrayList<>();
        generateSubsequences("abc", 0, "", result);
        System.out.println("All subsequences of 'abc': " + result);
        
        List<List<Integer>> numResult = new ArrayList<>();
        generateSubsets(new int[]{1, 2, 3}, 0, new ArrayList<>(), numResult);
        System.out.println("All subsets of [1,2,3]: " + numResult);
    }

    public static void generateSubsequences(String str, int index, String current, List<String> result) {
        if (index == str.length()) {
            result.add(current);
            return;
        }

        generateSubsequences(str, index + 1, current + str.charAt(index), result);
        generateSubsequences(str, index + 1, current, result);
    }

    public static void generateSubsets(int[] arr, int index, List<Integer> current, List<List<Integer>> result) {
        if (index == arr.length) {
            result.add(new ArrayList<>(current));
            return;
        }

        current.add(arr[index]);
        generateSubsets(arr, index + 1, current, result);
        current.remove(current.size() - 1);

        generateSubsets(arr, index + 1, current, result);
    }
}