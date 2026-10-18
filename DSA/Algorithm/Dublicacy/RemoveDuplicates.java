
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;

public class RemoveDuplicates {
    public static int[] removeDuplicates(int[] arr) {
//        This is the simplest approach, where you utilize a HashSet to
//        automatically handle duplicates as you add elements. However, this method
//        requires a significant amount of memory.
        HashSet<Integer> set = new HashSet<>();
        for (int num : arr) {
            set.add(num);
        }
        int[] result = new int[set.size()];
        int i = 0;
        for (int num : set) {
            result[i++] = num;
        }
        return result;
    }
    // another way to remove duplicate...
    public static void removeDuplicates2(int[] arr) {
        int maxValue = 1000000000; // Assuming values are within this range
        boolean[] bitmap = new boolean[maxValue + 1];

        for (int num : arr) {
            bitmap[num] = true;
        }

        // Now output unique elements based on the bitmap
        for (int i = 0; i <= maxValue; i++) {
            if (bitmap[i]) {
                System.out.println(i);
            }
        }
    }

    // removing duplicate from string.
    public static String removeDuplicates3(String input) {
        LinkedHashSet<Character> set = new LinkedHashSet<>();
        StringBuilder output = new StringBuilder();

        for (char c : input.toCharArray()) {
            if (set.add(c)) {
                output.append(c);
            }
        }

        return output.toString();
    }
    // another method..
    public static String removeDuplicates(String input) {
        boolean[] seen = new boolean[26]; // for 'a' to 'z'
        StringBuilder output = new StringBuilder();

        for (char c : input.toCharArray()) {
            if (!seen[c - 'a']) {
                seen[c - 'a'] = true;
                output.append(c);
            }
        }

        return output.toString();
    }


    public static void main(String[] args) {
        int arr[] = {-2,-3,-4,-2,-2,-1,-6,-3};
        System.out.println(Arrays.toString(removeDuplicates(arr)));

//        removeDuplicates2(arr);   only for positive integer arr.

        String input = "abracadabra";
        String result = removeDuplicates(input);
        System.out.println(result);  // Output: "abrcd"

        result = removeDuplicates(input);
        System.out.println(result);


    }
}

