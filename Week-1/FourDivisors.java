//https://dashboard.programmingpathshala.com/renaissance/practice/question?questionId=35&sectionId=1&moduleId=1&topicId=2&subtopicId=19&homeworkId=4
import java.util.*;
import java.lang.*;

public class FourDivisors
{
    public static void main (String[] args) throws java.lang.Exception
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int i=0;i<t;i++){
            int n = sc.nextInt();
            int[] arr = new int[n];
            for(int j=0;j<n;j++){
                arr[j] = sc.nextInt();
            }
            int sum = 0;
            for(int j=0;j<n;j++){
                List<Integer> list = new ArrayList<>();
                noHasFourDivisors(list, arr[j]);
                if(list.size() == 4){
                    for(int k=0;k<list.size();k++){
                        sum += list.get(k);
                    }
                }
            }
            System.out.println(sum);
        }
    }

    public static void noHasFourDivisors(List<Integer> list, int n){
        for(int i=1;i<=Math.sqrt(n);i++){
            if(n%i == 0){
                if(i*i == n) list.add(i);
                else{
                    list.add(i);
                    list.add(n/i); // from the above 1 point
                }
            }
        }
    }
}