import java.util.Arrays;
import java.lang.*;
public class ArrayOperation {
    public static void main(String[] args){
        int arr[] = {1,33,4,78,3,8,4,3};
        System.out.println(Arrays.stream(arr).min().getAsInt());
    }

    public static class ModularArithmetic {
        public static void main(String[] args) {
    //        int M = 47;
    //        int n = 21;
    //        long num = modularArith(n,M);
    //        System.out.println(num);
    //
    //        System.out.println(binaryExpon(3,13,M));
    //        System.out.println(binaryExpon(2,M,M-1));

            int gcd = gcdCal(12,18);
            System.out.println(12*18 / gcd);

            System.out.println(chinesRem(new int[]{1,2},new int[]{3,4}));
        }

        static long binaryExpon(int a, int b, int M){
            long ans = 1 ;
            while(b > 0){
                if((b&1) != 0){
                    ans = (ans  *  a) % M;
                }
                a = (a  *  a) % M;
                b >>=1;
            }
            return ans;
        }
        static long modularArith(int n, int  M){
            long fact = 1;
            for(int i  = 1; i <= n; i++){
                fact = ((fact % M) * (i % M)) % M;
                // fact = (fact * i) % M;
            }
            return fact;
        }
        static int gcdCal(int a, int b){
            if(b == 0){
                return a;
            }else{
                return gcdCal(b,a % b);
            }

        }
        static int chinesRem(int[] nums, int rem[]){
            int x = 1;
            while(true){
                int i;
                for( i= 0; i < nums.length; i++){
                    if(x % nums[i] != rem[i]){
                        break;
                    }
                }
                if(i == nums.length){
                    return x;
                }
                x++;
            }
        }

    }
}
