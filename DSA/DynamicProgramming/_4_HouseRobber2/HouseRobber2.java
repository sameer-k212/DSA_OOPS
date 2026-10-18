
public class HouseRobber2 {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 1) return nums[0];

        int arr1[] = new int[n - 1];
        int arr2[] = new int[n - 1];
        for (int i = 0; i < n; i++) {
            if(i != 0){
                arr1[i-1] = nums[i];
            }
            if(i != n-1){
                arr2[i] = nums[i];
            }
        }

        return Math.max(spaceOpt(arr1), spaceOpt(arr2));

    }

    // tabulation + spaceOptimization
    public int spaceOpt(int nums[]) {
        int n = nums.length;
        int prev = nums[0];
        int prev2 = 0;

        for (int i = 1; i < n; i++) {

            int take = nums[i];
            if (i > 1)
                take += prev2;
            int notTake = 0 + prev;

            int currMax = Math.max(take, notTake);
            prev2 = prev;
            prev = currMax;
        }
        return prev;
    }
}
