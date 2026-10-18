
public class HourCount {
    public static int pairhours(int nums[], int n) {
        int  pair = 0;
        for (int i =0;i<n;i++){
            for(int j = i+1;j<n;j++){
                if (nums[i]%60 == 0){
                    pair++;
                }else if ((nums[i]+nums[j])%60 == 0){
                    pair++;
                }

            }
        }

        return pair;

    }

    public static void main(String[] args) {
        int nums[] = {2,2,58,60,60};
        int n = nums.length;
        System.out.println(pairhours(nums,n));

    }



}
