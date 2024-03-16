//https://leetcode.com/problems/longest-consecutive-sequence/
import java.util.*;
public class LongestConsecutiveSequence { // used streak logic
    public int longestConsecutive(int[] nums) {
        Set<Integer> map = new HashSet<>();
        Set<Integer> visited = new HashSet<>();

        for(int i : nums){
            map.add(i);
        }

        int ans = 0;
        for(int i=0;i<nums.length;i++){
            if(map.contains(nums[i]-1)) continue;
            if(visited.contains(nums[i])) continue;
            visited.add(nums[i]);
            int len = 0;
            int x = nums[i];
            while(map.contains(x)){
                len++;
                x++;
            }
            ans = Math.max(ans, len);
        }
        return ans;
    }
}
