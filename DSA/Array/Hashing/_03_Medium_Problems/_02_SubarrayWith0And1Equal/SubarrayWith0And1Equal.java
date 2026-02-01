package DSA.Array.Hashing._03_Medium_Problems._02_SubarrayWith0And1Equal;

import java.util.*;

public class SubarrayWith0And1Equal {
    public int maxLen(int[] arr, int n) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int sum = 0, res = 0;
        
        for (int i = 0; i < n; i++) {
            if (arr[i] == 0) {
                sum += -1;
            } else {
                sum += 1;
            }
            
            if (map.containsKey(sum)) {
                int idx = map.get(sum);
                res = Math.max(res, i - idx);
            } else {
                map.put(sum, i);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        SubarrayWith0And1Equal obj = new SubarrayWith0And1Equal();
        int[] arr = {0, 1, 0, 1, 1, 0};
        System.out.println(obj.maxLen(arr, arr.length)); // 6
    }
}
