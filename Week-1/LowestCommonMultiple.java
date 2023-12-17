public class LowestCommonMultiple {
    public static void main(String[] args) {
        int[] arr = { 12, 1, 22, 3, 4, 42 };
        System.out.println(lcmOfNelements(arr));
        System.out.println(lcm(12, 11));
    }

    public static int gcd(int a, int b){
        int max = Math.max(a, b);
        int min = Math.min(a, b);
        if(min == 0) return max;
        while(max%min != 0){
            int temp = max;
            max = min;
            min = temp%min;
        }

        return min;
    }

    public static int lcm(int a, int b){
        // lcm(a, b) = a*b/gcd(a, b); formula
        int prod = a*b;
        int ans = prod/gcd(a, b);
        return ans;
    }

    public static int lcmOfNelements(int[] arr){
        int ans = arr[0];
        for(int i=1;i<arr.length;i++){
            ans = lcm(ans, arr[i]);
        }
        return ans;
    }
}
