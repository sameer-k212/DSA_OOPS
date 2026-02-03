package DSA_OOPS.DSA.Algorithm.BinarySearch._03_FirstLastPosition;

public class FirstLastPosition {
    public static int[] searchRange(int[] nums, int target) {
        int[] result = {-1, -1};
        result[0] = findFirst(nums, target);
        result[1] = findLast(nums, target);
        return result;
    }
    
    private static int findFirst(int[] nums, int target) {
        int left = 0, right = nums.length - 1, result = -1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                result = mid;
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return result;
    }
    
    private static int findLast(int[] nums, int target) {
        int left = 0, right = nums.length - 1, result = -1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                result = mid;
                left = mid + 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return result;
    }
    
    public static void main(String[] args) {
        int[] nums = {5, 7, 7, 8, 8, 10};
        int[] result = searchRange(nums, 8);
        System.out.println("Range: [" + result[0] + ", " + result[1] + "]");
    }
}
