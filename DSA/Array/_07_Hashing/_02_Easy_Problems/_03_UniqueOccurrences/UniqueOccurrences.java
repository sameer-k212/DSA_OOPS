package DSA.Array._07_Hashing._02_Easy_Problems._03_UniqueOccurrences;

import java.util.*;

public class UniqueOccurrences {
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> countMap = new HashMap<>();

        // Count occurrences
        for (int num : arr) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }

        Set<Integer> countSet = new HashSet<>();

        // Check if counts are unique
        for (int count : countMap.values()) {
            if (!countSet.add(count)) {
                return false; // Duplicate count found
            }
        }

        return true; // All counts are unique
    }

    public static void main(String[] args) {
        UniqueOccurrences obj = new UniqueOccurrences();
        System.out.println(obj.uniqueOccurrences(new int[]{1,2,2,1,1,3})); // true
        System.out.println(obj.uniqueOccurrences(new int[]{1,2})); // false
    }
}
