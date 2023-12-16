//https://dashboard.programmingpathshala.com/renaissance/homepage/assignment?questionid=9&sequence=8
import java.util.*;
public class MinSwapsToBringTogether { // using the sliding window approach

    public static void main (String[] args) throws java.lang.Exception
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];

        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }

        int legalElementCount = 0;
        for(int i=0;i<n;i++){
            if(arr[i] <= k){
                legalElementCount++;
            }
        }
        int windowSize = legalElementCount; // cause we have to group these amount of elements together that's why it will be the window size
        int count = 0;
        for(int i=0;i<windowSize;i++){
            if(arr[i]<=k) count++;
        }

        int max_count = Integer.MIN_VALUE;
        for(int i=windowSize;i<n;i++){
            max_count = Math.max(max_count, count);
            if(arr[i] <= k) count++;
            if(arr[i-windowSize] <= k) count--;
        }
        max_count = Math.max(max_count, count);

        System.out.println(legalElementCount-max_count);

        // for below function
        int[] nums = { 1,1,0,0,1 };
        System.out.println(minSwaps(nums));
    }

    //https://leetcode.com/problems/minimum-swaps-to-group-all-1s-together-ii/  (leetcode problem) same logic but little bit difference
    public static int minSwaps(int[] nums) {
        int n = nums.length;
        int ones = 0;
        for(int i=0;i<n;i++){
            if(nums[i] == 1) ones++;
        }
        int count = 0;
        for(int i=0;i<ones;i++){
            if(nums[i] == 1) count++;
        }

        int nums2[] = new int[n*2];
        for(int i=0;i<n*2;i++){
            nums2[i] = nums[i%n];
        }

        int max_count = Integer.MIN_VALUE;

        for(int i=ones;i<n*2;i++){
            max_count = Math.max(max_count, count);
            if(nums2[i] == 1) count++;
            if(nums2[i-ones] == 1) count--;
        }
        max_count = Math.max(max_count, count);

        return ones-max_count;
    }

}
