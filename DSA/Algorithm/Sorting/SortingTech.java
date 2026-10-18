import java.util.*;
public class SortingTech {
    public static void main(String[] args) {
//        int arr[]= {7,6,9,4,11,5,2};
//        int ans[]=mergesort(arr,0,arr.length-1);
//        for(int i=0;i<ans.length;i++) {
//            System.out.print(ans[i]+" ");
//        }

        int[] arr= {7,6,9,4,11,2,0};
//        quick_sort(arr,0,arr.length-1);
//        for (int j : arr) {
//            System.out.print(arr[j]);
//        }
//        int[] arr = {20,50,10,65,90};
//        selectionSort(arr);
//        System.out.println(Arrays.toString(arr));

        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));

//        insertionSort(arr);
//        System.out.println(Arrays.toString(arr));
    }
    public static int[] mergesort(int arr[],int si,int ei) {
        if(si==ei) {
            return new int[]{arr[si]};
        }

        int mid=(si+ei)/2;

        int ans1[] = mergesort(arr,si,mid);
        int ans2[] = mergesort(arr,mid+1,ei);

        return mergeArrays(ans1,ans2);
    }

    public static  int[] mergeArrays(int[] arr1, int[] arr2) {
        int i = 0, j = 0, k = 0;
        int n = arr2.length;
        int m = arr1.length;
        int arr3[] = new int[m + n];
        while (i < m && j < n) {
            if (arr1[i] < arr2[j])
                arr3[k++] = arr1[i++];
            else
                arr3[k++] = arr2[j++];
        }
        while (i < m)
            arr3[k++] = arr1[i++];
        while (j < n)
            arr3[k++] = arr2[j++];
        return arr3;
    }
    // quick sort.
    public static void quick_sort(int arr[],int si,int ei) {
        if(si>=ei) {
            return;
        }

        int pivot=partition(arr,si,ei);
        quick_sort(arr,si,pivot-1);
        quick_sort(arr,pivot+1,ei);
    }

    public static int partition(int []arr, int si, int ei ) {
        int pivot=arr[ei]; // pivot element.
        int idx=si;
        for(int i=si;i<ei;i++){
            if(arr[i]<pivot) {
                int temp=arr[idx];
                arr[idx++]=arr[i];
                arr[i]=temp;
            }
        }
        int temp=arr[ei];
        arr[ei]=arr[idx];
        arr[idx]=temp;
        return idx;
    }

    // selection sort.
    public static void selectionSort(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            int min_idx = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[min_idx] > arr[j]) {
                    min_idx = j;
                }
            }
            if (min_idx != i) {
                int temp = arr[min_idx];
                arr[min_idx] = arr[i];
                arr[i] = temp;
            }
        }
    }

    // bubble sort.

    public static void bubbleSort(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            boolean swap = false;
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swap = true;
                }
            }
            if (!swap) {
                break;
            }
        }
    }


    // insertion sort.
    public static void insertionSort(int arr[]){
        for (int i = 1;i < arr.length; i++){
            int j = i;
            while(j>0&&arr[j]<arr[j-1]){
                int temp = arr[j-1];
                arr[j-1] = arr[j];
                arr[j] = temp;
                j--;
            }
        }
    }




}
