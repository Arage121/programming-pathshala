import java.util.Arrays;

public class SlidingWindow { // this is a method used widely in solving different types of problems like sum of k-length subarrays or max (related to subarray)

    public static void main(String[] args) {
        int[] arr = { 1, 3, -1, 2, 4, 8, 7, 9, 1 };
        int k = 3;
        System.out.println(Arrays.toString(sumOfSubarrays(arr, k)));
        System.out.println(Arrays.toString(freqOfXInSubarrays(arr, 1, k)));
    }

    public static int[] sumOfSubarrays(int[] arr, int k){
        int n = arr.length;
        int[] ans = new int[n-k+1];
        int sum = 0;
        for(int i=0;i<k;i++){
            sum += arr[i];
        }
        for(int i=k,j=0;i<n;i++,j++){
            ans[j] = sum;
            sum += arr[i];
            sum -= arr[i-k];
        }
        ans[n-k] = sum;
        return ans;
    }

    public static int[] freqOfXInSubarrays(int[] arr, int x, int k){
        int n = arr.length;
        int[] ans = new int[n-k+1];

        int freq = 0;
        for(int i=0;i<k;i++){
            if(arr[i] == x) freq++;
        }

        for(int i=k,j=0;i<n;i++,j++){
            ans[j] = freq;
            if(arr[i] == x) freq++;
            if(arr[i-k] == x) freq--;
        }
        ans[n-k] = freq;

        return ans;
    }
}
