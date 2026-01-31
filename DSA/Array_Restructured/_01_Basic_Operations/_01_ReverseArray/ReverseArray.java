package DSA.Array_Restructured._01_Basic_Operations._01_ReverseArray;

public class ReverseArray {
    public static void reverse(int[] arr) {
        int left = 0, right = arr.length - 1;
        while (left < right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        int[] arr = {2, 4, 6, 8, 10, 12, 14};
        reverse(arr);
        for (int num : arr) System.out.print(num + " ");
    }
}
