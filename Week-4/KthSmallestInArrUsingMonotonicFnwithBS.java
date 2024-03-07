//https://dashboard.programmingpathshala.com/renaissance/practice/question?questionId=103&sectionId=1&moduleId=2&topicId=6&subtopicId=77&assignmentId=16
import java.util.*;
public class KthSmallestInArrUsingMonotonicFnwithBS { // monotonic function is like non-increasing function or non-decreasing functions, and after identifying
    // the property in some problem and making a function like it, we can solve the problem simply using binary search
    public static void main (String[] args) throws java.lang.Exception
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        int k = sc.nextInt();

        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            max = Math.max(max, arr[i]);
            min = Math.min(min, arr[i]);
        }

        System.out.println(binarySearchonAns(arr, n, k, max, min));
    }

    public static int binarySearchonAns(int[] arr, int n, int k, int max, int min){
        int low = min;
        int high = max;

        while(low <= high){
            int mid = low+(high-low)/2;
            int count = countOse(arr, mid);
            if(count < k) low = mid+1; // count < k part
            else{ // you are in count >= k part
                int cnt = countOse(arr, mid-1);
                if(cnt < k) return mid;
                else high = mid-1;
            }
        }
        return -1;
    }

    public static int countOse(int[] arr, int x){ //CountOfSmallerOrEqualElements of an element is this function work
        int count = 0;
        for(int i=0;i<arr.length;i++){
            if(arr[i] <= x) count++;
        }
        return count;
    }
}
