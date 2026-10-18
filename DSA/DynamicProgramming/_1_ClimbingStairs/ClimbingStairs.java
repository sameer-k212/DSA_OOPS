import java.util.*;
public class ClimbingStairs {
    public static Map<Integer, Integer> memo = new HashMap<>();
    public int climbStairs0(int n) {
        if(n == 1 || n == 2){
            return n;
        }

        // avoid the re-computations of the function calls
        if(memo.containsKey(n)){
            return memo.get(n);
        }

        // recursive function call
        int numWays = climbStairs0(n - 1) + climbStairs0(n - 2);
        memo.put(n, numWays);
        return numWays;
    }

//Tabulation approach

// tabulation approach - no recursion
// time complexity - O(n)
// space complexity(array based ds) - O(n)


    public int climbStairs1(int n) {
        if(n == 1){
            return 1;
        }
        // intialization
        int[] cs = new int[n+1];
        cs[1] = 1;
        cs[2] = 2;

        for(int i=3; i<=n; i++){
            cs[i] = cs[i-1] + cs[i-2];
        }

        return cs[n];
    }

// Most optimized approach
// time complexity: O(n)
// space complexity: O(1)


    public int climbStairs2(int n) {
        if(n == 1){
            return 1;
        }

        int first = 1, second = 2, third;
        for(int i=3; i<=n; i++){
            third = first + second;
            first = second;
            second = third;
        }

        return second;
    }

}
