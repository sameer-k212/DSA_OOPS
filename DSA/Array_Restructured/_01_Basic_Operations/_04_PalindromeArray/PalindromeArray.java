package DSA.Array_Restructured._01_Basic_Operations._04_PalindromeArray;

public class PalindromeArray {
    public static boolean isPalindrome(int[] arr) {
        int left = 0, right = arr.length - 1;
        while (left < right) {
            if (arr[left] != arr[right]) return false;
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 2, 1};
        System.out.println("Palindrome: " + isPalindrome(arr));
    }
}
