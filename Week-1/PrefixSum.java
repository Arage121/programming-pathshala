public class PrefixSum { // prefixSum can come in handy when you are asked with the queries like sum(i, j)
    // i.e sum(i, j) - sum from i till j index, formula: sum(l, r) = arr[r] - arr[l-1] this arr contains all the prefix
    // sums of indexes from 0 to r, or 0 to l-1
    public static void main(String[] args) {
        int[] arr = { 1, 4, 5, 66, -1, 0 };
        System.out.println(prefixSum(1, 3, arr));
    }

    public static int prefixSum(int l, int r, int[] preSum){
        for(int i=1;i<preSum.length;i++){
            preSum[i] += preSum[i-1]; // calculating prefixSum, and storing it in original arr
        }
        if(l == 0) return preSum[r]; // as l is 0 so we will return till r as it is 0 to r prefixSum
        return preSum[r]-preSum[l-1];
    }
}
