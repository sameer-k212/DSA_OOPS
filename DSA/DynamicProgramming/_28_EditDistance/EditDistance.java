
public class EditDistance {
    public static void main(String[] args) {
        String s1 = "horse"; int n1 = s1.length();
        String s2 = "ros"; int n2 = s2.length();

//        System.out.println(recursion(s1, n1-1, s2, n2-1));

//        int[][] dp = new int[n1][n2];
//        for(int arr[] : dp){
//            Arrays.fill(arr, -1);
//        }
//        System.out.println(memo(s1, n1-1, s2, n2-1, dp));

//        System.out.println(tabulation(s1, s2));

        System.out.println(spaceOpt(s1, s2));
    }
    public static int recursion(String s1, int i1, String s2, int i2){
        if(i1 < 0) return i2+1;
        if(i2 < 0) return i1+1;


        // in string Do always matching and non-matching
        if(s1.charAt(i1) == s2.charAt(i2)){
            return 0 + recursion(s1, i1-1, s2, i2-1); // matched
        }
        else{
            return Math.min(1 + recursion(s1, i1, s2, i2-1), // insert
                    Math.min(1 + recursion(s1, i1-1, s2, i2), // delete
                            1 + recursion(s1, i1-1, s2, i2-1))); // replace
        }
    }
    public static int memo(String s1, int i1, String s2, int i2, int[][] dp){
        if(i1 < 0) return i2+1;
        if(i2 < 0) return i1+1;

        if(dp[i1][i2] != -1) return dp[i1][i2];

        // in string Do always matching and non-matching
        if(s1.charAt(i1) == s2.charAt(i2)){
            return dp[i1][i2] = 0 + memo(s1, i1-1, s2, i2-1, dp); // matched
        }
        else{
            return dp[i1][i2] = Math.min(1 + memo(s1, i1, s2, i2-1, dp), // insert
                    Math.min(1 + memo(s1, i1-1, s2, i2, dp), // delete
                            1 + memo(s1, i1-1, s2, i2-1, dp))); // replace
        }
    }
    public static int tabulation(String s1, String s2){
        int n1 = s1.length();
        int n2 = s2.length();
        int dp[][] = new int[n1+1][n2+1];

        for(int i = 0 ; i <= n1; i++){
            dp[i][0] = i;
        }
        for(int j = 0 ; j <= n2; j++){
            dp[0][j] = j;
        }

       for(int i = 1; i <= n1; i++){
           for(int j = 1; j <= n2; j++){
               if(s1.charAt(i-1) == s2.charAt(j-1)){
                   dp[i][j] = dp[i-1][j-1]; // matched
               }
               else{
                   dp[i][j] = Math.min(1 + dp[i][j-1], // insert
                           Math.min(1 + dp[i-1][j], // delete
                                   1 + dp[i-1][j-1])); // replace
               }
           }
       }

       return dp[n1][n2];
    }
    public static int spaceOpt(String s1, String s2){
        int n1 = s1.length();
        int n2 = s2.length();
        int prev[] = new int[n2+1];

        for(int j = 0 ; j <= n2; j++){
            prev[j] = j;
        }

        for(int i = 1; i <= n1; i++){
            int curr[] = new int[n2+1];
            curr[0] = i;
            for(int j = 1; j <= n2; j++){
                if(s1.charAt(i-1) == s2.charAt(j-1)){
                    curr[j] = prev[j-1]; // matched
                }
                else{
                    curr[j] = 1 + Math.min(curr[j-1], // insert
                            Math.min(prev[j], // delete
                                    prev[j-1])); // replace
                }
            }
            prev = curr;
        }
        return prev[n2];
    }
}
