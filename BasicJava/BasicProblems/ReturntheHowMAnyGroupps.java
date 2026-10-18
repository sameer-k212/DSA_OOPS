
public class ReturntheHowMAnyGroupps {
    public static int groups(int n, int nums[]){
        int countEven = 0;
        int countOdd = 0;
        for (int i = 0;i<n;i++){
            if (nums[i]%2 == 0){
                countEven++;
            }else {
                countOdd++;
            }
        }
        return Math.min(countEven,countOdd);
    }
    public static void main(String[] args) {
        int n = 4;
        int nums[] = {5,2,3,6,4,7};
        System.out.println(groups(n,nums));
    }
}
