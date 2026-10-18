import java.util.*;
public class Find_Original_Typed_String_II {
    int mod = 1000000007;

    static int val = 0;
    public int possibleStringCount(String word, int k) {
        List<Integer> list = new ArrayList<>();

        // abb list me frequency add karo
        int count = 1;
        for(int i = 0 ; i < word.length()-1; i++){
            if(word.charAt(i) == word.charAt(i+1)){
                count++;
            }else{
                list.add(count);
                count = 1;
            }
        }
        System.out.println(val);
        list.add(count);

        // agar uniq character >= k hain matlab sare combinations valid honge.
        int totalPossibleOriginalStrings = prod(list);
        if(list.size() >= k) return totalPossibleOriginalStrings;

        // else part me hame find karna hoga no of invaild so that we can substract
        // with total then after we get total valid.
        int dp[][] =  new int[list.size()][k+1];
        for(int arr[] : dp){
            Arrays.fill(arr, -1);
        }

        // int invailidStrings = memo(0, 0, list, k, dp);
        // int invailidStrings = tabulation(list, k);
        int invailidStrings = tabulationOpt(list, k);


        // valid strings will be. But listen bro :
        // (a - b) % MOD  ==  (a - b + MOD) % MOD this is formula because may be (b > a).
        return (int)(((totalPossibleOriginalStrings - (long)invailidStrings + mod) % mod));
    }
    public static int memo(int idx, int count, List<Integer> list, int k, int dp[][]){
        if(idx == list.size()){
            if(count < k) return 1;
            else return 0;
        }

        if(dp[idx][count] != -1) return dp[idx][count];

        long ans = 0;
        for(int take = 1; take <= list.get(idx); take++){
            if(count + take < k){
                ans = (ans + memo(idx + 1, count + take, list, k, dp)) % 1000000007;
            }else{
                break;
            }
        }

        return dp[idx][count] = (int)ans;
    }
    public int tabulation(List<Integer> list, int k){
        int dp[][] = new int[list.size() + 1][k];

        // base case ho gya ye toh.
        for(int count = 0; count < k; count++){
            dp[list.size()][count] = 1;
        }


        // try out all possible paths.
        for(int idx = list.size()-1; idx >= 0; idx--){
            for(int count = 0; count < k; count++){
                int ans = 0;
                for(int take = 1; take <= list.get(idx); take++){
                    if(count + take < k){
                        ans =  (ans + dp[idx+1][count + take]) % mod;
                    }else{
                        break;
                    }
                }
                dp[idx][count] = (int)ans;
            }
        }

        // agar last se start karte hain toh ans first cell hoga most of the cases else Vice versa.
        return dp[0][0];
    }
    public int tabulationOpt(List<Integer> list, int k){
        int dp[][] = new int[list.size() + 1][k];
        int mod = 1000000007;

        // base case ho gya ye toh.
        for(int count = 0; count < k; count++){
            dp[list.size()][count] = 1;
        }

        // try out all possible paths.
        for(int idx = list.size() - 1; idx >= 0; idx--){
            // prefix sum nikal lo next row ka

            long[] prefix = new long[k + 1];
            for(int i = 0; i < k; i++){
                prefix[i + 1] = (prefix[i] + dp[idx + 1][i]) % mod;
            }

            for(int count = 0; count < k; count++){
                int maxTake = list.get(idx);
                int l = count + 1;
                int r = Math.min(k - 1, count + maxTake);

                // agar count + take < k ho raha ho toh hi valid hai
                if(l <= r){
                    dp[idx][count] = (int)((prefix[r + 1] - prefix[l] + mod) % mod);
                } else {
                    dp[idx][count] = 0;
                }
            }
        }

        // agar last se start karte hain toh ans first cell hoga most of the cases else Vice versa.
        return dp[0][0];
    }



    public int prod(List<Integer> list){
        long prod = 1;

        for(int val : list){
            prod = (prod *  val) % 1000000007;
        }

        return (int)prod;
    }
    public static void main(String[] args) {

    }
}
