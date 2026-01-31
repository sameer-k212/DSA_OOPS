package DSA.Array_Restructured._05_Intersection_And_Merging._01_ArrayIntersection;

import java.util.*;

public class ArrayIntersection {
    public static List<Integer> intersection(int[] arr1, int[] arr2) {
        Set<Integer> set1 = new HashSet<>();
        for (int num : arr1) set1.add(num);
        
        Set<Integer> result = new HashSet<>();
        for (int num : arr2) {
            if (set1.contains(num)) result.add(num);
        }
        
        return new ArrayList<>(result);
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 2, 2, 4, 3};
        int[] arr2 = {3, 3, 6, 1};
        System.out.println(intersection(arr1, arr2));
    }
}
