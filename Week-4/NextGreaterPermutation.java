//https://dashboard.programmingpathshala.com/renaissance/practice/question?questionId=137&sectionId=1&moduleId=2&topicId=7&subtopicId=90&assignmentId=20
import java.util.*;
public class NextGreaterPermutation {
    public static void main (String[] args) throws java.lang.Exception
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0){
            int n = sc.nextInt();
            int[] arr = new int[n];
            for(int i=0;i<n;i++){
                arr[i] = sc.nextInt();
            }
            ngp(arr, n);

            for(int i=0;i<n;i++){
                System.out.print(arr[i]+" ");
            }
            System.out.println();
        }
    }

    public static void ngp(int[] arr, int n){
        int j = n-1;
        while(j>0 && arr[j] <= arr[j-1]){
            j--;
        }
        if(j == 0){
            int s = 0;
            int e = n-1;
            while(s < e){
                int temp = arr[s];
                arr[s] = arr[e];
                arr[e] = temp;
                s++;
                e--;
            }
        }
        if(j-1 >= 0){
            for(int i=n-1;i>=j;i--){
                if(arr[i] > arr[j-1]){
                    int temp = arr[i];
                    arr[i] = arr[j-1];
                    arr[j-1] = temp;
                    break;
                }
            }
            int s = j;
            int e = n-1;
            while(s < e){
                int temp = arr[s];
                arr[s] = arr[e];
                arr[e] = temp;
                s++;
                e--;
            }
        }
    }
}
