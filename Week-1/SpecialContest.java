//https://dashboard.programmingpathshala.com/renaissance/practice/question?questionId=29&sectionId=1&moduleId=1&topicId=2&subtopicId=19&assignmentId=4
import java.util.*;
import java.lang.*;
public class SpecialContest { // this problem used the gcd and lcm + venn diagrams logic
    public static void main (String[] args) throws java.lang.Exception {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int i=0;i<t;i++) {
            int n = sc.nextInt();
            int a = sc.nextInt();
            int b = sc.nextInt();
            int k = sc.nextInt();
            if (func(n, a, b, k)) {
                System.out.println("Win");
            } else {
                System.out.println("Lose");
            }
        }
    }
    public static boolean func(int n, int a, int b, int k){
        int ans = (n/a)+(n/b)-(2*(n/lcm(a, b)));
        if(ans >= k){
            return true;
        }
        return false;
    }
    public static int lcm(int a, int b){
        int prod = a*b;
        int ans = prod/gcd(a, b);
        return ans;
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

}

