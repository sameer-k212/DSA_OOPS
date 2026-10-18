
public class IsIsotonic {
    static boolean isIsotonic(int nums[]){
    int m=1;
    int n=1;
    int o=1;
        if(nums.length<=2){
        return true;
    }
        else{
        for(int i =0;i<nums.length-1;i++){
            if(nums[i]<nums[i+1]){
                m++;
            }
            else if(nums[i]>nums[i+1]){
                n++;
            }
            else
            {
                o++;
            }
        }
        if((m+o)==nums.length+1 || ((n+o)==nums.length+1))
        {
            return true;
        }
        else
        {
            return false;
        }
    }

}

    public static void main(String[] args) {
        boolean bool=isIsotonic(new int[]{1,2,3,3,4});
        System.out.println(bool);
    }
}

