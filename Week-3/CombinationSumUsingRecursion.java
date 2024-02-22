//https://leetcode.com/problems/combination-sum/
import java.util.*;
public class CombinationSumUsingRecursion {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> list =  new ArrayList<>();
        List<Integer> l  =  new ArrayList<>();
        allCombinationSum(candidates, target, 0 , list, l);
        return list;
    }




    public void allCombinationSum(int [] candidates , int target, int i,List<List<Integer>> list , List<Integer> l) {
        if (target == 0) {
            list.add(new ArrayList<>(l));
            return;
        }
        if(target < 0) {
            return ;
        }
        if(i == candidates.length) {
            return;
        }
        l.add(candidates[i]);
        allCombinationSum(candidates,target-candidates[i],i,list,l);
        l.remove(l.size() -1);
        allCombinationSum(candidates,target,i+1,list,l);
    }
}
