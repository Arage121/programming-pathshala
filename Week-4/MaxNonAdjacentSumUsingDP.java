//https://www.geeksforgeeks.org/problems/stickler-theif-1587115621/1
public class MaxNonAdjacentSumUsingDP { // both top-bottom and bottom-top dp approaches used
    //Function to find the maximum money the thief can get.
    public int FindMaxSum(int arr[], int n)
    {
        int[] ans = new int[n+1]; // this is bottom-top dp approach (i.e iterative)
        ans[0] = Math.max(0, arr[0]);
        ans[1] = Math.max(ans[0], arr[1]);
        for(int i=2;i<n;i++){
            ans[i] = Math.max(arr[i]+ans[i-2], ans[i-1]);
        }
        return ans[n-1];
        //   int[] dp = new int[n+1]; this is top-bottom approach
        //   Arrays.fill(dp, -1);
        //   return maxSum(arr, dp, 0, n);
    }

     public int maxSum(int[] arr, int[] dp, int i, int n){ // top-bottom dp approach (i.e using recursion+memoization)
         if(i >= n) return 0;
         if(dp[i] != -1) return dp[i];
         dp[i] = Math.max(arr[i]+maxSum(arr, dp, i+2, n), maxSum(arr, dp, i+1, n));
         return dp[i];
     }
}
