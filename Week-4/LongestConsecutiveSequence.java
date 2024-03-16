//https://leetcode.com/problems/longest-consecutive-sequence/
import java.util.*;
public class LongestConsecutiveSequence { // used streak logic
    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) // Handle edge case: empty array
            return 0;

        Map<Integer, Integer> map = new HashMap<>(); // Map to store the streaks
        int ans = 0;

        for(int num : nums) {
            if (!map.containsKey(num)) {
                int leftStreak = map.getOrDefault(num - 1, 0); // Get streak of left adjacent number
                int rightStreak = map.getOrDefault(num + 1, 0); // Get streak of right adjacent number
                int currentStreak = leftStreak + rightStreak + 1; // Calculate current streak

                ans = Math.max(ans, currentStreak); // Update the maximum streak

                // Update streaks for current number and its neighbors
                map.put(num, currentStreak);
                map.put(num - leftStreak, currentStreak);
                map.put(num + rightStreak, currentStreak);
            }
        }

        return ans;
    }
}
