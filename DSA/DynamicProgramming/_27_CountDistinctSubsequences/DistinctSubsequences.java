
public class DistinctSubsequences {
    public static void main(String[] args) {
        String s1 = "babgbag"; int n1 = s1.length();
        String s2 = "bag"; int n2 = s2.length();

//        System.out.println(recursion(s1, n1-1, s2,n2-1));

//        int dp[][] = new int[n1][n2];
//        for(int arr[] : dp){
//            Arrays.fill(arr, -1);
//        }
//        System.out.println(memo(s1, n1-1, s2,n2-1, dp));

//        System.out.println(tabulation(s1, s2));

        System.out.println(spaceOpt(s1, s2));
    }
    public static int recursion(String s1, int  i1, String s2, int i2){
        // Base Case
        if (i2 < 0) return 1;
        if(i1 < 0) return 0;


        if(s1.charAt(i1) == s2.charAt(i2)){
            return recursion(s1, i1-1, s2, i2-1) + recursion(s1, i1-1, s2, i2);
        }
        else{
            return recursion(s1, i1-1, s2, i2);
        }
    }
    public static int memo(String s1, int  i1, String s2, int i2, int dp[][]){
        if (i2 < 0) return 1;
        if(i1 < 0) return 0;

        if(dp[i1][i2] != -1) return dp[i1][i2];

        if(s1.charAt(i1) == s2.charAt(i2)){
            return dp[i1][i2] = recursion(s1, i1-1, s2, i2-1) + recursion(s1, i1-1, s2, i2);
        }
        else{
            return dp[i1][i2] = recursion(s1, i1-1, s2, i2);
        }
    }
    public static int tabulation(String s1, String s2){
        int n1 = s1.length();
        int n2 = s2.length();

        int dp[][] = new int[n1+1][n2+1];

        for(int i = 0; i <= n1; i++){
            dp[i][0] = 1;
        }

        for(int i = 1; i <= n1; i++){
            for(int j = 1; j <= n2; j++){
                if(s1.charAt(i-1) == s2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
                }
                else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        return dp[n1][n2];
    }
    public static int spaceOpt(String s1, String s2){
        int n1 = s1.length();
        int n2 = s2.length();

        int prev[] = new int[n2+1];

        prev[0] = 1;

        for(int i = 1; i <= n1; i++){
            int curr[] = new int[n2+1];
            curr[0] = 1;
            for(int j = 1; j <= n2; j++){
                if(s1.charAt(i-1) == s2.charAt(j-1)){
                    curr[j] = prev[j-1] + prev[j];
                }
                else{
                    curr[j] = prev[j];
                }
            }
            prev = curr;
        }

        return prev[n2];
    }

}
