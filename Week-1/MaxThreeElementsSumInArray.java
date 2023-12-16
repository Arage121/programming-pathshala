import java.util.Arrays;

public class MaxThreeElementsSumInArray {
    // you can find the max of three elements sum, i.e all elements should be max and it should follow the rule i<j<k, you can find it in simple manner
    // but it will give time limit exceeded as it will be O(n^3)
    // we will use our prefixMax and suffixMax approach here, first we will fix the middle max(e.g i index) element and find the first using prefixMax[i-1] and
    // last max using suffixMax[i+1] these two will be containing the max. elements from 0 to i-1 and n-1 to i+1 (and most importantly the complexity will be O(n) only
    public static void main(String[] args) {
        int[] arr = { 1, 5, 90, 15, 7, 77, 0 };
        int n = arr.length;
        int[] prefixMax = new int[n];
        int[] suffixMax = new int[n];

        prefixMax[0] = arr[0];
        for(int i=1;i<n;i++) {
            prefixMax[i] = Math.max(prefixMax[i - 1], arr[i]);
        }

        suffixMax[n-1] = arr[n-1];
        for(int i=n-2;i>=0;i--){
            suffixMax[i] = Math.max(suffixMax[i+1], arr[i]);
        }

        int x = 0;
        int ans = Integer.MIN_VALUE;
        //fixing the middle max and getting the required sum of three max elements in array which follows the rule i < j < k respectively
        for(int i=1;i<n-1;i++){ // it will run from 1 to n-2 as middle element can't be first or last element otherwise how we will add the
        // prefixMax and suffixMax element
            x = prefixMax[i-1]+arr[i]+suffixMax[i+1];
            ans = Math.max(ans, x);
        }

        System.out.println(ans);
    }
}
