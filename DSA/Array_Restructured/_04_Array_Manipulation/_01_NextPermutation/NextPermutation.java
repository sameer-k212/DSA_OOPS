package DSA.Array_Restructured._04_Array_Manipulation._01_NextPermutation;

import java.util.Arrays;

public class NextPermutation {
    public static void nextPermutation(int[] arr) {
        int pivot = -1;
        for (int i = arr.length - 2; i >= 0; i--) {
            if (arr[i] < arr[i + 1]) {
                pivot = i;
                break;
            }
        }
        
        if (pivot == -1) {
            reverse(arr, 0, arr.length - 1);
            return;
        }
        
        for (int i = arr.length - 1; i > pivot; i--) {
            if (arr[i] > arr[pivot]) {
                swap(arr, i, pivot);
                break;
            }
        }
        
        reverse(arr, pivot + 1, arr.length - 1);
    }
    
    private static void reverse(int[] arr, int start, int end) {
        while (start < end) {
            swap(arr, start++, end--);
        }
    }
    
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        nextPermutation(arr);
        System.out.println(Arrays.toString(arr));
    }
}
