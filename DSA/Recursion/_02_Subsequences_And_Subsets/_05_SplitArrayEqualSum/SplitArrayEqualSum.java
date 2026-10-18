
import java.util.ArrayList;
import java.util.List;

public class SplitArrayEqualSum {
    static int count = 0;

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6};
        count = 0;
        splitArray(arr, 0, 0, 0, new ArrayList<>(), new ArrayList<>());
        System.out.println("Total ways to split: " + count);
    }

    public static void splitArray(int[] arr, int index, int sum1, int sum2, 
                                  List<Integer> list1, List<Integer> list2) {
        if (index == arr.length) {
            if (sum1 == sum2 && !list1.isEmpty() && !list2.isEmpty()) {
                count++;
                System.out.println(list1 + " = " + list2);
            }
            return;
        }

        list1.add(arr[index]);
        splitArray(arr, index + 1, sum1 + arr[index], sum2, list1, list2);
        list1.remove(list1.size() - 1);

        list2.add(arr[index]);
        splitArray(arr, index + 1, sum1, sum2 + arr[index], list1, list2);
        list2.remove(list2.size() - 1);
    }
}