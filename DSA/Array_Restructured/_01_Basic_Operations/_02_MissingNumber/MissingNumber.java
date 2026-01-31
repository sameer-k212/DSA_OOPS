package DSA.Array_Restructured._01_Basic_Operations._02_MissingNumber;

public class MissingNumber {
    public static int findMissing(int[] arr) {
        int n = arr.length;
        int expectedSum = n * (n + 1) / 2;
        int actualSum = 0;
        for (int num : arr) actualSum += num;
        return expectedSum - actualSum;
    }

    public static void main(String[] args) {
        int[] arr = {3, 0, 1};
        System.out.println("Missing: " + findMissing(arr));
    }
}
