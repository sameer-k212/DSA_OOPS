
class TwoSum {
    public static int[] twoSum(int[] nums, int target) {
        int arr[]=new int[2];
        int m=0;
        for(int i=0;i<nums.length;i++)
        {
            for(int j=i+1;j<=nums.length-1;j++)
            {
                if(nums[i]+nums[j]==target)
                {
                    arr[0]=i;
                    arr[1]=j;
                    m++;
                    break;
                }
            }
            if(m==1)
            {
                break;
            }
        }
        return arr;

    }
    public static void main(String args[])
    {
        int i = 6;
        int arr[]=twoSum(new int []{3,2,3},i);
        System.out.println(arr[0]+","+arr[1]);
    }
}