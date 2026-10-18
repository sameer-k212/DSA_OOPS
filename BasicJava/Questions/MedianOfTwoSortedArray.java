
import java.util.Arrays;

public class MedianOfTwoSortedArray {
    public static void main(String[] args) {
        int nums1[] = {2, 3};
        int nums2[] = {1, 2};
        double d = medianOfTwoArray(nums1,nums2);
    }


        public static double medianOfTwoArray(int nums1[],int nums2[]){
            int i = 0;
            int nums3[] = new int[nums1.length + nums2.length];
            for(; i < nums1.length; i++){
                nums3[i] = nums1[i];
            }
            for(int j = 0; j < nums2.length; j++){
                nums3[i] = nums2[j];
                i++;
            }
            Arrays.sort(nums3);
            if(nums3.length % 2 != 0){
                return (double)nums3[nums3.length/2];
            }else{
                return ((double)nums3[(nums3.length/2)-1]+ (double)nums3[(nums3.length/2)])/(double)2;
            }
        }


}
