//https://www.geeksforgeeks.org/problems/count-ways-to-reach-the-nth-stair-1587115620/1
public class DynamicProgrammingQues1 { // dp is basically recursion + memoization( it basically means that we store it in some memory, so that we don't need
    // to repeat the function calls that are already have been calculated one time, if another time it's called then we simply return the value stored )
    // dp is divided into two types - Bottom-Top dp(iterative) and Top-Bottom dp(recursive)
    // Define a constant for modulo operation
    private static final int MOD = 1000000007;

    // Function to count number of ways to reach the nth stair.
    // this is top-bottom dp approach
    // int countWays(int n) {
    //     int[] ans = new int[n + 1];
    //     Arrays.fill(ans, -1);
    //     return (int) func(ans, 0, n);
    // }

    // long func(int[] ans, int i, int n) {
    //     if (i == n) return 1;
    //     if (i > n) return 0;

    //     if (ans[i] != -1) return ans[i];

    //     // Use modulo operation to prevent overflow
    //     ans[i] = (int) ((func(ans, i + 1, n) % MOD + func(ans, i + 2, n) % MOD) % MOD);

    //     return ans[i];
    // }

    // below is bottom-top dp approach
    int countWays(int n) {
        if(n < 0) return 0;
        if(n == 0) return 1;
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i=2;i<=n;i++){
            dp[i] = (dp[i-1]+dp[i-2]) % MOD;
        }
        return dp[n];
    }
}
