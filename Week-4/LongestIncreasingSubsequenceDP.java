//https://leetcode.com/problems/longest-increasing-subsequence/
public class LongestIncreasingSubsequenceDP {
    public int lengthOfLIS(int[] nums) { // used bottom-top dp
        int ans = Integer.MIN_VALUE;
        int[] LIS = new int[nums.length];
        for(int i=0;i<nums.length;i++){ // LIS[i] -> longest increasing subsequence length including nums[i]
            LIS[i] = 1;
            for(int j=0;j<i;j++){
                if(nums[i] > nums[j]) LIS[i] = Math.max(LIS[i], 1+LIS[j]);
            }
            ans = Math.max(ans, LIS[i]);
        }
        return ans;
    }
}
