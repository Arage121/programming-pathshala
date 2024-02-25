//https://leetcode.com/problems/permutations/
import java.util.*;
public class PermutationsUsingBacktracking {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        permute(result, nums, 0);
        return result;
    }

    public void permute(List<List<Integer>> result, int[] nums, int i){
        if(i == nums.length-1){
            List<Integer> list = new ArrayList<>();
            for(int num : nums){
                list.add(num);
            }
            result.add(list);
            return;
        }
        for(int j=i;j<nums.length;j++){
            swap(nums, i, j); // do
            permute(result, nums, i+1); // call
            swap(nums, i, j); // undo  ... and this is called backtracking
        }
    }

    public void swap(int[] nums, int a, int b){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
