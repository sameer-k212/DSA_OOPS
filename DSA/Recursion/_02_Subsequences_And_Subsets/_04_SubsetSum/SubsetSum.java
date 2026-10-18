
import java.util.ArrayList;
import java.util.List;

public class SubsetSum {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        int target = 3;
        
        List<List<Integer>> result = new ArrayList<>();
        findSubsetsWithSum(arr, target, 0, new ArrayList<>(), result);
        System.out.println("Subsets with sum " + target + ": " + result);
    }

    public static void findSubsetsWithSum(int[] arr, int target, int index, List<Integer> current, List<List<Integer>> result) {
        if (target == 0) {
            result.add(new ArrayList<>(current));
            return;
        }
        
        if (index >= arr.length || target < 0) {
            return;
        }

        current.add(arr[index]);
        findSubsetsWithSum(arr, target - arr[index], index + 1, current, result);
        current.remove(current.size() - 1);

        findSubsetsWithSum(arr, target, index + 1, current, result);
    }
}