
public class RodCutting {
    public int cutRod(int[] price) {
        // code here
        int lengthOfRod =  price.length;
        int n = price.length;
        // return recursion(lengthOfRod, n-1, price);

        // int[][] dp = new int[n][lengthOfRod+1];
        // for(int arr[] : dp){
        //     Arrays.fill(arr, -1);
        // }
        // return memo(lengthOfRod, n-1, price, dp);

        // return tabulation(lengthOfRod, price);

        return spaceOpt(lengthOfRod, price);
    }
    public int recursion(int rodLen, int idx, int[] price){
        if(idx == 0){
            return rodLen * price[0];
        }

        int notTake = 0 + recursion(rodLen, idx-1, price);
        int take = Integer.MIN_VALUE;
        int currRodLen = idx+1;
        if(currRodLen <= rodLen){
            take = price[idx] + recursion(rodLen-currRodLen, idx, price);
        }

        return Math.max(take, notTake);
    }
    public int memo(int rodLen, int idx, int[] price, int[][] dp){
        if(idx == 0){
            return rodLen * price[0];
        }

        if(dp[idx][rodLen] != -1){
            return dp[idx][rodLen];
        }

        int notTake = 0 + memo(rodLen, idx-1, price, dp);
        int take = Integer.MIN_VALUE;
        int currRodLen = idx+1;
        if(currRodLen <= rodLen){
            take = price[idx] + memo(rodLen-currRodLen, idx, price, dp);
        }

        return dp[idx][rodLen] = Math.max(take, notTake);
    }
    public int tabulation(int rodLen, int[] price){
        int n = price.length;
        int dp[][] = new int[n][rodLen+1];

        // Filling the Base Case....
        for(int rl = 0; rl <= rodLen; rl++){
            dp[0][rl] = rl * price[0];
        }

        // Try Out All Possible Paths.
        for(int i = 1; i < n; i++){
            for(int rl = 0; rl <= rodLen; rl++){

                int notTake = 0 + dp[i-1][rl];
                int take = Integer.MIN_VALUE;
                int currRodLen = i+1;
                if(currRodLen <= rl){
                    take = price[i] + dp[i][rl-currRodLen];
                }

                dp[i][rl] = Math.max(take, notTake);
            }
        }



        return dp[n-1][rodLen];
    }
    public int spaceOpt(int rodLen, int[] price){
        int n = price.length;
        int prev[] = new int[rodLen+1];

        // Filling the Base Case....
        for(int rl = 0; rl <= rodLen; rl++){
            prev[rl] = rl * price[0];
        }

        // Try Out All Possible Paths.
        for(int i = 1; i < n; i++){
            int curr[] = new int[rodLen+1];
            for(int rl = 0; rl <= rodLen; rl++){

                int notTake = 0 + prev[rl];
                int take = Integer.MIN_VALUE;
                int currRodLen = i+1;
                if(currRodLen <= rl){
                    take = price[i] + curr[rl-currRodLen];
                }

                curr[rl] = Math.max(take, notTake);
            }
            prev = curr;
        }



        return prev[rodLen];
    }
}
