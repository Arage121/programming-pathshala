//https://www.geeksforgeeks.org/problems/coin-change2448/1
import java.util.*;
public class CoinChange2UsingDP { // used both dp approaches
    public long count(int coins[], int N, int sum) { // bottom-top dp
        long[] memo = new long[sum+1];
        Arrays.fill(memo, 0);
        memo[0] = 1;

        for(int i=1;i<=coins.length;i++){
            for(int j=1;j<memo.length;j++){
                if(j >= coins[i-1]) memo[j] += memo[j-coins[i-1]];
            }
        }
        return memo[sum];
    }
    // public long count(int coins[], int N, int sum) { // top-bottom dp
    //     long[][] memo = new long[N][sum+1];
    //     for(long[] row : memo){
    //         Arrays.fill(row, -1);
    //     }
    //     return func(coins, memo, N-1, sum);
    // }

    // public long func(int coins[], long[][] memo, int N, int sum){
    //     if(sum == 0) return 1;
    //     if(sum < 0) return 0;
    //     if(N < 0) return 0;
    //     if(memo[N][sum] != -1) return memo[N][sum];
    //     memo[N][sum] = func(coins, memo, N-1, sum)+func(coins, memo, N, sum-coins[N]);
    //     return memo[N][sum];
    // }
}
