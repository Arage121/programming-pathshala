import java.util.*;

public class NnaturalNosUsingQueue { // Given a +ve no. N, Print first 'N' natural numbers whose digits are including { 1, 2, 3 }. Print them in sorted form.
    public static void main(String[] args) { // we will do using recursion and then use level order traversal to get it in sorted form
        // we will add the first element and then pop it and it's children in the queue
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // n natural type numbers according to this method
        Queue<Integer> q = new LinkedList<>();
        q.offer(0);
        int count = 0;
        while(count < n){
            int x = q.peek();
            if(x != 0){
                count++;
                System.out.print(x + " ");
            }
            q.poll();
            q.offer(x*10+1);
            q.offer(x*10+2);
            q.offer(x*10+3);
        }
    }
}
