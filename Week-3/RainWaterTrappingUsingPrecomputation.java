//https://dashboard.programmingpathshala.com/renaissance/practice/question?questionId=2&sectionId=1&moduleId=1&topicId=1&subtopicId=6&assignmentId=1
import java.util.*;
public class RainWaterTrappingUsingPrecomputation // using suffixMax and prefixMax
{
    public static void main (String[] args) throws java.lang.Exception
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[] arr = new long[n]; 
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextLong(); 
        }
        long[] prefixMax = new long[n]; 
        long[] suffixMax = new long[n]; 
        prefixMax[0] = arr[0];
        for (int i = 1; i < n; i++) {
            prefixMax[i] = Math.max(prefixMax[i - 1], arr[i]);
        }
        suffixMax[n - 1] = arr[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            suffixMax[i] = Math.max(suffixMax[i + 1], arr[i]);
        }

        long sum = 0; 
        for (int i = 1; i < n - 1; i++) {
            long h = Math.min(prefixMax[i - 1], suffixMax[i + 1]); 
            if (h > arr[i]) {
                sum += h - arr[i];
            }
        }
        System.out.println(sum);
    }
}