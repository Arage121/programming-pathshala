//https://dashboard.programmingpathshala.com/renaissance/practice/question?questionId=145&sectionId=1&moduleId=2&topicId=7&subtopicId=99&assignmentId=23
import java.io.*;
public class InversionCount { // inversion count is the total count of elements that are in i position which is left than j where i < j && arr[i] >= arr[j]
    static long[] temp; // Global temporary array

    static long merge(long arr[], int left, int mid, int right) {
        int i = left, j = mid, k = 0;
        long invCount = 0;
        while ((i < mid) && (j <= right)) {

            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
                invCount += (mid - i);
            }

        }

        while (i < mid) {
            temp[k++] = arr[i++];
        }

        while (j <= right) {
            temp[k++] = arr[j++];
        }

        for (i = left, k = 0; i <= right; i++, k++) {
            arr[i] = temp[k];
        }

        return invCount;
    }

    static long mergeSortAndCount(long arr[], int left, int right) {
        long count = 0;
        if (right > left) {
            int mid = (right + left) / 2;
            count += mergeSortAndCount(arr, left, mid);
            count += mergeSortAndCount(arr, mid + 1, right);
            count += merge(arr, left, mid + 1, right);
        }
        return count;
    }

    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int t = Integer.parseInt(br.readLine());
            while (t-- > 0) {
                int n = Integer.parseInt(br.readLine());
                long[] arr = new long[n];
                temp = new long[n]; // Initialize global temporary array

                String[] elements = br.readLine().split(" ");
                for (int i = 0; i < n; i++) {
                    arr[i] = Long.parseLong(elements[i]);
                }
                System.out.println(mergeSortAndCount(arr, 0, n - 1));
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
