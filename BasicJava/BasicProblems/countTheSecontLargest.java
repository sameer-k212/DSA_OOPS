//import

import java.net.spi.InetAddressResolver;
import java.util.*;

public class countTheSecontLargest {
    public static void secondLargest(int nums[]) {
        List<Integer> list = new ArrayList<>();
        int max = max1(nums);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != max) {
                list.add(nums[i]);

            }
        }
        System.out.println(list);
        int max2 = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) > max2) {
                max2 = list.get(i);

            }

        }
        System.out.println(max2);
        int count = 0;
        for (int i= 0;i<list.size();i++){
            if (list.get(i)==max2){
                count++;
            }

        }
        System.out.println(count);

    }
    public static int max1(int nums[]){
        int max = 0;
        for (int i = 0;i<nums.length;i++){
            if (nums[i]>max){
                max = nums[i];
            }
        }
        return max;

    }
    public static void main(String[] args) {
        int nums[] = {1,3,2,3,4,5,6,6,5};
        secondLargest(nums);

    }
}
