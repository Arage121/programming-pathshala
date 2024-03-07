//https://www.geeksforgeeks.org/maximum-subarray-size-subarrays-size-sum-less-k/
public class MaximizeKUsingMontonicFunc { // monotonic function with bs on ans
    public static void main(String[] args) {
        int[] arr = { 1, 2, 10, 4 };
        int k = 14;
        System.out.println(maxK(arr, k, arr.length));
    }

    public static int maxK(int[] arr, int k, int n){
        int s = 0;
        int e = n;
        while(s <= e){
            int m = s+(e-s)/2;
            if(!isPossible(arr, m, k)){
                e = m-1;
            }else{
                if(!isPossible(arr, m+1, k)) return m;
                else s = m+1;
            }
        }
        return -1;
    }

    public static boolean isPossible(int[] arr, int m, int k){
        if(m == arr.length+1) return false;
        int sum = 0;
        for(int i=0;i<m;i++){
            sum += arr[i];
        }
        if(sum > k) return false;
        // System.out.println(m);
        for(int e=m ; e<arr.length ; ++e) {
            sum -= arr[e-m];
            sum += arr[e];

            // System.out.println(sum);

            if(sum > k) return false;
        }
        // System.out.println();
        return true;
    }
}
