package DSA.DynamicProgramming;

import java.util.Arrays;

public class Fibonacci {
    // recursive
    public static int fibo(int num){
        if(num <= 1){
            return num;
        }
        return fibo(num-1) + fibo(num-2);
    }
    // recursive + memorization(TD)
    public static int memorization(int dp[],int num){
        if(num <= 1) return num;

        if(dp[num] != -1) return dp[num];

        return dp[num] = memorization(dp,num-1) + memorization(dp,num-2);
    }
    // O(1) Space: space optimization(BU)
    public static int tabulation(int prev, int prev2,int n){
        for(int i = 0; i < n; i++){
            int curr = prev + prev2;
            prev = prev2;
            prev2 = curr;
        }
        return prev2;

    }
    // O(1) Space
    public static int fib(int n){
        int a = 0, b = 1, c;
        if(n == 0){
            return a;
        }
        for(int i=2; i<=n; i++){
            c = a + b;
            a = b;
            b = c;
        }

        return b;
    }
    public static void main(String[] args) {
        int  n = 5;
        int dp[] = new int[n+1];
        Arrays.fill(dp,-1);
        System.out.println(memorization(dp,n));

        System.out.println(tabulation(1,0,n));
    }
}
