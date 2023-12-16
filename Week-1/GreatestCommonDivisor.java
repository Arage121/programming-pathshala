public class GreatestCommonDivisor { // GCD
    public static void main(String[] args) {
        System.out.println(gcd(18, 12));
        int[] arr = { 24, 32, 36, 40 };
        System.out.println(gcdOfEntireArray(arr));
    }

    public static int gcd(int a, int b){ // time complexity in worst case will be O(logN)
        int max = Math.max(a, b); // this logic is Euclid's division algorithm
        int min = Math.min(a, b);
        if(min == 0) return max;
        while(max % min != 0){
            int temp = max;
            max = min;
            min = temp%min;
        }

        return min;
    }

    public static int gcdOfEntireArray(int[] nums){
        if(nums.length == 1) return nums[0];
        int ans = nums[0];
        for(int i=1;i<nums.length;i++){
            ans = gcd(nums[i], ans);
        }
        return ans;
    }
}
