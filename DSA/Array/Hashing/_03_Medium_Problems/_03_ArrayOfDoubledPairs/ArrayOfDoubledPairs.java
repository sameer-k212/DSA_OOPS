package DSA.Array.Hashing._03_Medium_Problems._03_ArrayOfDoubledPairs;

import java.util.*;

public class ArrayOfDoubledPairs {
    public boolean canReorderDoubled(int[] arr) {
        if (arr.length == 0) return true;

        Arrays.sort(arr);
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }

        for (int i = 0; i < arr.length; i++) {
            if (!map.containsKey(arr[i]) || map.get(arr[i]) == 0) continue;

            if (arr[i] < 0) {
                if (arr[i] % 2 != 0) return false;
                if (map.containsKey(arr[i] / 2) && map.get(arr[i] / 2) > 0) {
                    map.put(arr[i] / 2, map.get(arr[i] / 2) - 1);
                    map.put(arr[i], map.get(arr[i]) - 1);
                } else {
                    return false;
                }
            } else {
                if (map.containsKey(arr[i] * 2) && map.get(arr[i] * 2) > 0) {
                    map.put(arr[i] * 2, map.get(arr[i] * 2) - 1);
                    map.put(arr[i], map.get(arr[i]) - 1);
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        ArrayOfDoubledPairs obj = new ArrayOfDoubledPairs();
        System.out.println(obj.canReorderDoubled(new int[]{4,-2,2,-4})); // true
        System.out.println(obj.canReorderDoubled(new int[]{1,2,4,16,8,4})); // false
    }
}
