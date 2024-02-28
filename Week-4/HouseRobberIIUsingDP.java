//https://leetcode.com/problems/house-robber-ii/description/
import java.util.*;
public class HouseRobberIIUsingDP { // used top-bottom dp approach
    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }

        int n = nums.length;
        // we need two dp array because the first and last houses can't be robbed at a similar time
        // as they are adjacent because they are arranged in a circle
        // Calculate the maximum amount by robbing houses from 0 to n-2
        int[] dp1 = new int[n];
        Arrays.fill(dp1, -1);
        int max1 = robHelper(nums, dp1, 0, n - 1);

        // Calculate the maximum amount by robbing houses from 1 to n-1
        int[] dp2 = new int[n];
        Arrays.fill(dp2, -1);
        int max2 = robHelper(nums, dp2, 1, n);

        return Math.max(max1, max2);
    }

    private int robHelper(int[] nums, int[] dp, int start, int end) {
        int n = nums.length;
        if (start >= end) return 0;
        if (dp[start] != -1) return dp[start];
        dp[start] = Math.max(nums[start] + robHelper(nums, dp, start + 2, end), robHelper(nums, dp, start + 1, end));
        return dp[start];
    }
}
