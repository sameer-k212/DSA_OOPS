package DSA_OOPS.DSA.Algorithm.BinarySearch._01_BasicBinarySearch;

public class BinarySearch {
    public static int binarySearch(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (arr[mid] == target) return mid;
            else if (arr[mid] < target) left = mid + 1;
            else right = mid - 1;
        }
        return -1;
    }
    
    public static int binarySearchRecursive(int[] arr, int target, int left, int right) {
        if (left > right) return -1;
        
        int mid = left + (right - left) / 2;
        
        if (arr[mid] == target) return mid;
        else if (arr[mid] < target) return binarySearchRecursive(arr, target, mid + 1, right);
        else return binarySearchRecursive(arr, target, left, mid - 1);
    }
    
    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 7, 9, 11, 13};
        System.out.println("Found at: " + binarySearch(arr, 7));
    }
}
