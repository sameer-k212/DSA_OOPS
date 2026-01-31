package DSA.Array_Restructured._05_Intersection_And_Merging._02_MergeArrays;

public class MergeArrays {
    public static int[] merge(int[] arr1, int[] arr2) {
        int[] result = new int[arr1.length + arr2.length];
        int i = 0, j = 0, k = 0;
        
        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] <= arr2[j]) result[k++] = arr1[i++];
            else result[k++] = arr2[j++];
        }
        
        while (i < arr1.length) result[k++] = arr1[i++];
        while (j < arr2.length) result[k++] = arr2[j++];
        
        return result;
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 3, 5};
        int[] arr2 = {2, 4, 6};
        int[] merged = merge(arr1, arr2);
        for (int num : merged) System.out.print(num + " ");
    }
}
