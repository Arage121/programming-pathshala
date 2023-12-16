import java.util.Arrays;

public class RotateArray {
    public static void main(String[] args) {
        int[] arr = { 1, 5, 2, 4, 3 };
        rotateArrayIII(arr, 2);
        System.out.println(Arrays.toString(arr));
    }

    public static void rotateArray(int[] arr, int k){ // this O(n^2) time complexity with O(1) space
        int n = arr.length;
        for(int j=0;j<k%n;j++){
            int x = arr[n-1];
            for(int i=n-2;i>=0;i--){
                arr[i+1] = arr[i];
            }
            arr[0] = x;
        }
    }

    public static void rotateArrayII(int[] arr, int k){ // this is O(n) time complexity with O(n) space
        int n = arr.length;
        int[] nums = new int[n];

        for(int i=0;i<n;i++){
            nums[(i+k)%n] = arr[i];
        }

        for(int i=0;i<n;i++){
            arr[i] = nums[i];
        }
    }

    public static void rotateArrayIII(int[] arr, int k) {
        int n = arr.length;
        k = k % n; // Ensure k is within the bounds of the array length

        // Reverse the last k elements (part-1)
        for (int i = 0; i < k / 2; i++) {
            int temp = arr[n - k + i];
            arr[n - k + i] = arr[n - 1 - i];
            arr[n - 1 - i] = temp;
        }

        // Reverse the first n - k elements (part-2)
        for (int i = 0; i < (n - k) / 2; i++) {
            int temp = arr[i];
            arr[i] = arr[n - k - 1 - i];
            arr[n - k - 1 - i] = temp;
        }

        // Reverse the whole array
        for (int i = 0; i < n / 2; i++) {
            int temp = arr[i];
            arr[i] = arr[n - 1 - i];
            arr[n - 1 - i] = temp;
        }
    }
}
