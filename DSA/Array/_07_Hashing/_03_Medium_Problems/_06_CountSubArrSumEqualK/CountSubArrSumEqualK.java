package DSA.Array._07_Hashing._03_Medium_Problems._06_CountSubArrSumEqualK;

import java.util.HashMap;

public class CountSubArrSumEqualK {
//    Example 2:
//    Input: nums = [1,2,3], k = 3
//    Output: 2

    public int subarraySum(int[] arr, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0,1);
        int sum = 0;
        int count = 0;

        for(int i = 0; i < arr.length; i++){
            sum = sum + arr[i];
            if(map.containsKey(sum-k)){
                count += map.get(sum-k);
            }
            map.put(sum,map.getOrDefault(sum,0)+1);
        }
        return count;

    }

    // check subarray present in arr whose sum is divisible by k.
//    Input: nums = [23,2,6,4,7], k = 6
//    Output: true
//    Explanation: [23, 2, 6, 4, 7] is an continuous subarray of size 5 whose elements sum up to 42.
//            42 is a multiple of 6 because 42 = 7 * 6 and 7 is an integer.
    public boolean isSubarrayDivisibleByK(int[] arr, int k){
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int sum = 0;

        for(int i = 0; i < arr.length; i++){
            sum += arr[i];
            int rem = sum % k;
            if(map.containsKey(rem)){
                if(i - map.get(rem) > 1) return true;
            }else {
                map.put(rem, i);
            }
        }
        return false;
    }

}
