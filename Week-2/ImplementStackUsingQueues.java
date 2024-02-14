//https://leetcode.com/problems/implement-stack-using-queues/
import java.util.*;
public class ImplementStackUsingQueues {
    Queue<Integer> q = new LinkedList<>();
    int top;
    public ImplementStackUsingQueues() {
    }

    public void push(int x) {
        top = x;
        q.offer(x);
    }

    public int pop() {
        Queue<Integer> temp = new LinkedList<>();
        while(q.size() > 1){
            top = q.poll();
            temp.offer(top);
        }
        int x = q.poll();
        q = temp;
        return x;
    }

    public int top() {
        return top;
    }

    public boolean empty() {
        return q.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */