
public class TwoPointer {
    public static void main(String[] args) {
        // two pointer Approach. Mostly applied for sorted array.
        int arr[] = {10, 20,40, 50, 60, 70, 80, 90 ,100};
        int target =  100;
        int i = 0;
        int j = arr.length-1;
        while(i < j) {
            if (arr[i] + arr[j] == target) {
                System.out.println(arr[i] + "," + arr[j]);
                i++;
                j--;
            } else if (arr[i] + arr[j] > target) {
                j--;
            } else {
                i++;
            }
        }
    }

    // calculation of gcd
    static int gcdCal(int a, int b){
        if(b == 0){
            return a;
        }else{
            return gcdCal(b,a % b);
        }
    }


}
