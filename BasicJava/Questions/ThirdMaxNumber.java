// {1,1,2} = 2
// {1,2,3,2,3} =1
// {1,2} = 2
// {1,2,3} = 1
// {5,3,7,1,9} = 5
import java.util.Arrays;
public class ThirdMaxNumber {
    void RemoveDublicate(int arr[]) {
        System.out.println("YOUR GIVEN DSA.ARRAY:");
        for(int i=0;i<arr.length;i++) {
            System.out.print(arr[i]+" ");
        }
        System.out.println();
        int count = 0;
        System.out.println("After removing dublication:");
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] == arr[j]) {
                    arr[i] = -1;
                    count++;
                }
            }
        }
        int a=0;
        int arr1[] = new int[arr.length-count];
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]!=-1){
                    arr1[a] = arr[i];
                a++;
            }
        }
        Arrays.sort(arr1);
        for(int i=0;i<arr1.length;i++){
            System.out.print(arr1[i]+" ");
        }
        thirdMaxSum(arr1);
    }
    void thirdMaxSum(int []srtd_array){
        System.out.println();
        if(srtd_array.length<=3){
            System.out.println("THIRD MAX NUMBER WILL BE:"+srtd_array[srtd_array.length-1]);
        }
        else {
            System.out.println("THIRD MAX NUMBER:"+srtd_array[srtd_array.length-3]);
        }
    }
    public static void main(String args[]) {
        int arr[]={1,2,1,2,42,3};
        ThirdMaxNumber obj=new ThirdMaxNumber();
        obj.RemoveDublicate(arr);
    }
}
