//https://www.geeksforgeeks.org/problems/longest-bitonic-subsequence0824/1
public class LongestBitonicSubsequenceDP { // principle of LIS
    public int LongestBitonicSequence(int[] nums) // bottom-top dp approach
    {
        int n = nums.length;
        int[] LIS = new int[n];  // LIS -> Longest Increasing Subsequence till i including nums[i]
        int[] LDS = new int[n]; // LDS -> Longest Decreasing Subsequence from i to n including nums[i]
        for(int i=0;i<n;i++){
            LIS[i] = 1;
            for(int j=0;j<i;j++){
                if(nums[i] > nums[j]) LIS[i] = Math.max(LIS[i], 1+LIS[j]);
            }
        }

        int ans = Integer.MIN_VALUE;
        for(int i=n-1;i>=0;i--){
            LDS[i] = 1;
            for(int j=i+1;j<n;j++){
                if(nums[i] > nums[j]) LDS[i] = Math.max(LDS[i], 1+LDS[j]);
            }
            ans = Math.max(ans, LIS[i]+LDS[i]-1);
        }
        return ans;
    }
}
