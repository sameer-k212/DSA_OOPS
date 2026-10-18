
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

//       public is only mindetery with main method.
 public class Solution {
    static int[] topKFrequent(int[] nums, int k) {
         int array[] = new int[10];
         int n = 0;
         for (int m=0;m<nums.length;m++) {
             int count = 0;
             for (int j = 0; j < nums.length; j++) {
                 if (nums[m] == nums[j]) {
                     count++;
                 }
             }
             array[n] = count;
             n++;
         }
         return array;
     }
 }
class Solution1{
    public static  int[] productExceptSelf(int[] nums) {
        int array[] = new int[nums.length];
        for(int i=0;i<nums.length;i++){
            int sum =1;
            if(i==0){
                for(int j =1;j<nums.length;j++){
                    sum = sum*nums[j];
                }
                array[i] = sum;
            }
            else{
                for(int j =0;j<nums.length;j++){
                    if(j!=i){
                        sum = sum * nums[j];
                    }
                }
                array[i] = sum;
            }
        }
        return array;
    }
}
class Solution2 {
    public int compress(char[] chars) {
        String str = "";
        for(int j =0;j<chars.length;j++){
            int count=0;
            for(int i=0;i<chars.length-1;i++ ){
                if(chars[i]==chars[i+1]){
                    count++;
                }
                else{
                    str =str +chars[i];
                }
            }
            if(count!=0){
                str = str + count;
            }

        }
        return str.length();
    }
}
class Solution3 {
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int count =2;
        int array[] = new int [nums1.length+nums2.length+2];
        for(int i = 0;i<nums1.length;i++){
            array[i] = nums1[i];
        }
        int j = 0 ;
        for(int i = nums1.length;i<array.length-2;i++){
            array[i] = nums2[j];
            j++;
        }
    }
}

class Solution4 {
    public static int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE;
        int index=-1;
        for(int i=0;i<prices.length;i++){
            if(min>=prices[i]){
                min = prices[i];
            }
        }
        for(int i =0;i<prices.length;i++){
            if(min==prices[i]){
                index = i;
                break;
            }
        }
        int max = Integer.MIN_VALUE;
        int count =0;
        for (int i = index; i < prices.length; i++) {
            if(i==prices.length-1 && count==0){
                return 0;

            }
            else if (max <= prices[i]) {   // {7,1,5,3,6,4}
                max = prices[i];
            }
            count++;
        }

        return max-min;
    }
    }
class Solution5 {
    public static int maxArea(int[] height) {
        if(height.length==1|| height.length==0){
            return 0;
        }else if(height.length==2){
            int  value = height[0]<=height[1]? height[1]:height[0];
            return value;
        }else{
            int max1 = Integer.MIN_VALUE;
            for(int i = 0; i<height.length/2; i++){
                if(max1 <= height[i]){
                    max1 = height[i];
                }
            }
            int max2 = Integer.MIN_VALUE;
            for(int i = height.length/2; i<height.length; i++){
                if(max2 <= height[i] && height[i]<=max1){
                    max2 = height[i];
                }
            }
            return (max2-1)*(max2-1);
        }

    }
}
class Solution6 {
    public static int firstMissingPositive(int[] nums) {
        Arrays.sort(nums);
        int min = 0;
        for(int i = 0; i<nums.length-1;i++){
            if(nums[i]==nums[i+1]){
                nums[i] = 0;
            }
        }
        for(int i = 0; i<nums.length; i++){
            if(nums[i] > 0){
                if(min == nums[i]){
                    min++;
                }
            }
            else{
                break;
            }
        }
        return min+1;

    }
}
class Solution7 {
    public static int[] topKFrequent(int[] nums, int k) {
        if (nums.length <= k) {
            return nums; // If the array length is less than or equal to k, return the array as it is
        }

        Arrays.sort(nums);
        int count = 1;
        ArrayList<Integer> al = new ArrayList<>();

        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                count++;
            } else {
                if (count >= k) {
                    al.add(nums[i]);
                }
                count = 1; // Reset count for the new number
            }
        }

        // Check for the last element
        if (count >= k) {
            al.add(nums[nums.length - 1]);
        }

        // Convert ArrayList to array
        int[] arr = new int[al.size()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = al.get(i);
        }

        return arr;
    }
}

class solution7{
     public boolean canjump(int []nums){
         return true;
     }
}


   class Main{
        public static void main(String args[]){
//            int nums[] = {1,1,1,2,2,2,3};
//            int k=2;
//            int array[]=Solution.topKFrequent(nums,k);
//            System.out.println(Arrays.toString(array));

//            array = Solution1.productExceptSelf(new int[]{-1,-1,-1,1,1,-1});
//            System.out.println(Arrays.toString(array));
//            Solution3.merge(new int[]{1,2,3,0,0,0},3,new int[]{2,3,4},3);

//            int value = Solution4.maxProfit(new int[]{7,6,4,3,1});
//            System.out.println(value);
//            int new_value = Solution5.maxArea(new int[]{1,8,6,2,5,4,8,3,7});
//            System.out.println(new_value);

//              int arr[] = Solution7.topKFrequent(new int[]{1},1);
//              System.out.println(Arrays.toString(arr));
            


        }
    }
