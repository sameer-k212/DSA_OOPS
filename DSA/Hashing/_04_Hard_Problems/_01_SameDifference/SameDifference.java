package DSA.Hashing._04_Hard_Problems._01_SameDifference;

import java.util.*;

public class SameDifference {
    public long countPairs(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        long count = 0;
        
        for (int i = 0; i < arr.length; i++) {
            int num = arr[i] - i;
            if (map.containsKey(num)) {
                count += map.get(num);
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
            
            SameDifference obj = new SameDifference();
            System.out.println(obj.countPairs(arr));
        }
    }
}
