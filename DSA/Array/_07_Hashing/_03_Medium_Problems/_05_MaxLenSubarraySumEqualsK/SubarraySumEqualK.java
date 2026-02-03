package DSA.Array._07_Hashing._03_Medium_Problems._05_MaxLenSubarraySumEqualsK;

import java.util.HashMap;
import java.util.Map;

public class SubarraySumEqualK {
    /*
    Example : array has positive element only
    nums = [10, 5, 2, 7, 1, 9], k = 15
    */
    public static int maxLenSubArraySumEqualKPos(int  nums[], int k){
        int sum = 0;
        int maxLen = -(int)1e8;

        int left = 0;
        int right = 0;
        while(left <= right){

            while(left <= right && sum > k) {
                sum -= nums[left];
                left++;
            }
            if(sum == k){
                maxLen = Math.max(maxLen, right - left + 1);
            }

            right++;
            if(sum < k){
                sum += nums[right];
            }
        }

        return maxLen;
    }
    /*
     Example : array has +ve element or 0 or -ve
     */
    public static int maxLenSubArraySumEqualKAnyNumb(int nums[], int k){
        int n = nums.length;
        int maxLen = -(int)1e8;
        Map<Integer, Integer> prefixSum = new HashMap<>();

        int sum = 0;
        for(int i = 0; i < n; i++){
            sum += nums[i];

            if(sum == k){
                maxLen = i + 1;
            }

            if(prefixSum.containsKey(sum - k)){
                int endingIdx = i;
                int startingIdx = prefixSum.get(sum-k);
                maxLen = Math.max(maxLen, endingIdx - startingIdx + 1);
            }

            if(!prefixSum.containsKey(sum)){
                prefixSum.put(sum, i);
            }
        }

        return maxLen;
    }
}
