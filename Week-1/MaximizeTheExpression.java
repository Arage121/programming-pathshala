public class MaximizeTheExpression { // expression Max(p*arr[i]+ r*arr[j] + q*arr[k]) u have find this where i < j < k constraints (these can be changed)

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5 };
        System.out.println(marvoloGauntsRing(1, 2, 3, arr));
    }

    public static int marvoloGauntsRing(int p, int r, int q, int[] arr){ // here constraints are i <= j <= k
        int ans = Integer.MIN_VALUE;
        int n = arr.length;
        int[] prefixMax = new int[n];
        int[] suffixMax = new int[n];

        prefixMax[0] = p*arr[0]; // instead of putting max element at that point we will put p*arr[i] to easy the way to getting require max value of expression
        for(int i=1;i<n;i++){
            prefixMax[i] = Math.max(prefixMax[i-1], p*arr[i]);
        }

        suffixMax[n-1] = q*arr[n-1];
        for(int i=n-2;i>=0;i--){
            suffixMax[i] = Math.max(suffixMax[i+1], q*arr[i]);
        }

        //fixing the mid element and then founding the req value
        for(int i=0;i<n;i++){
            ans = Math.max(ans, prefixMax[i]+r*arr[i]+suffixMax[i]);
        }
        return ans;
    }

    public static int maximizeExpression(int p, int r, int q, int[] arr){
        int ans = Integer.MIN_VALUE;
        int n = arr.length;
        int[] prefixMax = new int[n];
        int[] suffixMax = new int[n];

        prefixMax[0] = p*arr[0]; // instead of putting max element at that point we will put p*arr[i] to easy the way to getting require max value of expression
        for(int i=1;i<n;i++){
            prefixMax[i] = Math.max(prefixMax[i-1], p*arr[i]);
        }

        suffixMax[n-1] = q*arr[n-1];
        for(int i=n-2;i>=0;i--){
            suffixMax[i] = Math.max(suffixMax[i+1], q*arr[i]);
        }

        //fixing the mid element and then founding the req value
        for(int i=1;i<n-1;i++){
            ans = Math.max(ans, prefixMax[i-1]+r*arr[i]+suffixMax[i+1]);
        }
        return ans;
    }
}
