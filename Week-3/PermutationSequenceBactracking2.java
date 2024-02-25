//https://leetcode.com/problems/permutation-sequence/
public class PermutationSequenceBactracking2 {
    int count = 1;
    String finalAns = null;
    public String getPermutation(int n, int k) {
        int[] nums = new int[n];
        for(int i=1;i<=n;i++){
            nums[i-1] = i;
        }
        func(nums, 0, n, k);
        return finalAns;
    }

    public void func(int[] nums, int indx, int n, int k){
        if(indx == n && count == k){
            StringBuilder sb = new StringBuilder();
            for(int i : nums){
                sb.append(i);
            }
            finalAns = sb.toString();
            count++;
            return;
        }
        if(indx == n){
            count++;
            return;
        }

        for(int j=indx;j<n;j++){
            rightRotate(nums, indx, j);
            func(nums, indx+1, n, k);
            leftRotate(nums, indx, j);
        }
    }

    public void rightRotate(int[] nums, int indx, int i){
        int temp = nums[i];
        for(int j=i;j>indx;j--){
            nums[j] = nums[j-1];
        }
        nums[indx] = temp;
    }

    public void leftRotate(int[] nums, int indx, int i){
        int temp = nums[indx];
        for(int j=indx;j<i;j++){
            nums[j] = nums[j+1];
        }
        nums[i] = temp;
    }
}
