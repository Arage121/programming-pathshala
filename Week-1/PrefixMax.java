public class PrefixMax {
    public static void main(String[] args) {
        int[] arr = { 1, 4, 2, 3, 44, 33 };
        int[] max = new int[arr.length];

        max[0] = arr[0];

        for(int i=1;i<max.length;i++){
            max[i] = Math.max(max[i-1], arr[i]); // similarly we can find the prefixMin by putting Math.min instead of Math.max
        }

        System.out.println(max[max.length-1]);
    }
}
