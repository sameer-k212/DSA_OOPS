package DSA.Hashing._02_Easy_Problems._04_IntersectionOfArrays;

import java.util.*;

public class IntersectionOfArrays {
    public ArrayList<Integer> intersect(int[] arr1, int[] arr2) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < arr1.length; i++) {
            if (map.containsKey(arr1[i])) {
                map.put(arr1[i], map.get(arr1[i]) + 1);
            } else {
                map.put(arr1[i], 1);
            }
        }
        
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < arr2.length; i++) {
            if (map.containsKey(arr2[i]) && map.get(arr2[i]) > 0) {
                list.add(arr2[i]);
                map.put(arr2[i], map.get(arr2[i]) - 1);
            }
        }
        return list;
    }

    public static void main(String[] args) {
        IntersectionOfArrays obj = new IntersectionOfArrays();
        int[] arr1 = {1, 2, 2, 1};
        int[] arr2 = {2, 2};
        System.out.println(obj.intersect(arr1, arr2)); // [2, 2]
    }
}
