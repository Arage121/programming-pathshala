//https://leetcode.com/problems/4sum/
import java.util.*;
public class FourSumUsingTwoPointer { // O(N^3) time complexity
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        func(result, nums, target);
        return result;
    }

    public void func(List<List<Integer>> result, int[] nums, int target){
        Arrays.sort(nums);
        int n = nums.length;
        for(int i=0;i<n-3;i++){
            if(i>0 && nums[i] == nums[i-1]) continue;
            for(int j=i+1;j<n-2;j++){
                if(j>i+1 && nums[j] == nums[j-1]) continue;
                long sum = target-(nums[i]+nums[j]);
                int p1 = j+1;
                int p2 = n-1;
                while(p1 < p2){
                    long currSum = nums[p1]+nums[p2];
                    if(currSum < sum) p1++;
                    else if(currSum > sum) p2--;
                    else{
                        currSum += nums[i]+nums[j];
                        if(currSum != target) return;
                        List<Integer> list = new ArrayList<>();
                        list.addAll(Arrays.asList(nums[i], nums[j], nums[p1], nums[p2]));
                        result.add(list);
                        if(nums[p1] == nums[p2]) break;
                        int x = nums[p1], y = nums[p2];
                        while(nums[p1] == x) p1++;
                        while(nums[p2] == y) p2--;
                    }
                }
            }
        }
    }
}