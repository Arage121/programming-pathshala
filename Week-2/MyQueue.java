//https://leetcode.com/problems/implement-queue-using-stacks/
import java.util.*;
public class MyQueue { // Implementing QUEUE using STACKS
    Stack<Integer> first = new Stack<>();
    Stack<Integer> second = new Stack<>();
    public MyQueue() {
    }
    
    public void push(int x) {
        first.push(x);
    }

    public void transferStack(){
        if(second.isEmpty()){
            while(!first.isEmpty()){
                second.push(first.pop());
            }
        }
    }
    
    public int pop() {
        transferStack();
        if(second.isEmpty()) return -1;
        return second.pop();
    }
    
    public int peek() {
        transferStack();
        if(second.isEmpty()) return -1;
        return second.peek();
    }
    
    public boolean empty() {
       return first.isEmpty() && second.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */