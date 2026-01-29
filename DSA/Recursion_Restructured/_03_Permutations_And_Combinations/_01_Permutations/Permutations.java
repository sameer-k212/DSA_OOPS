package DSA.Recursion_Restructured._03_Permutations_And_Combinations._01_Permutations;

import java.util.ArrayList;
import java.util.List;

public class Permutations {
    public static void main(String[] args) {
        List<List<Integer>> result1 = new ArrayList<>();
        permutationsArray(new int[]{1, 2, 3}, new ArrayList<>(), result1);
        System.out.println("Permutations of [1,2,3]: " + result1);
        
        System.out.println("\nPermutations of 'abc':");
        permutedString("abc", new ArrayList<>(), "");
        
        System.out.println("\nPermutations of numbers 1 to 3:");
        permutationsNumber(3, "", new boolean[3]);
    }

    public static void permutationsArray(int[] arr, List<Integer> current, List<List<Integer>> result) {
        if (current.size() == arr.length) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            if (current.contains(arr[i])) {
                continue;
            }
            
            current.add(arr[i]);
            permutationsArray(arr, current, result);
            current.remove(current.size() - 1);
        }
    }

    private static void permutedString(String s, List<String> ans, String curr) {
        if (curr.length() == s.length()) {
            ans.add(curr);
            return;
        }

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (curr.contains(String.valueOf(ch))) continue;

            permutedString(s, ans, curr + ch);
        }
    }

    public static void permutationsNumber(int n, String current, boolean[] used) {
        if (current.length() == n) {
            System.out.print(current + " ");
            return;
        }

        for (int i = 1; i <= n; i++) {
            if (used[i - 1]) {
                continue;
            }
            
            used[i - 1] = true;
            permutationsNumber(n, current + i, used);
            used[i - 1] = false;
        }
    }
}