//https://leetcode.com/problems/move-zeroes/
public class MoveZeroesToEnd {
    public void moveZeroes(int[] nums) { // application of quick sort partition approach used
        int i = 0;
        int count = 0;
        while(i < nums.length){
            if(nums[i] != 0){
                if(i != count){ // swap the non-zero element with zero so that it maintains the
                    // original relative order given in question
                    int temp = nums[i];
                    nums[i] = nums[count];
                    nums[count] = temp;
                }
                count++;
            }
            i++;
        }
    }
}
