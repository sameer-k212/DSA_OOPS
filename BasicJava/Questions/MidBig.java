import java.util.Arrays;
public class MidBig {
    public static void main(String[] args) {
        int arr[] = {9,6,8,3,7};
        for(int i = 0; i < arr.length; i++){
            if(i == arr.length-1){
                break;
            }else{
                int min = Math.min(arr[i],arr[i+1]);
                int max = Math.max(arr[i],arr[i+1]);
                if(i % 2 == 0){
                    arr[i] = min;
                    arr[i+1] = max;
                }else{
                    arr[i] = max;
                    arr[i+1] = min;
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}
