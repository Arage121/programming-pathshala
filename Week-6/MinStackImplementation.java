//https://leetcode.com/problems/min-stack/
import java.util.*;
public class MinStackImplementation {
    Stack<Long> st;
    long currMin;
    public MinStackImplementation() {
        st = new Stack<>();
        currMin = Long.MAX_VALUE;
    }

    public void push(int val) {
        long lval = 1L * val;
        if(st.isEmpty()){
            st.push(lval);
            currMin = lval;
            return;
        }
        if(lval < currMin){
            st.push(2L*val-currMin);
            currMin = lval;
        }else{
            st.push(lval);
        }
    }

    public void pop() {
        if(st.peek() < currMin){
            currMin = 2L*currMin - st.peek();
            st.pop();
        }else{
            st.pop();
        }
    }

    public int top() {
        long top = st.peek();
        if(top < currMin) return (int)currMin;
        return (int)top;
    }

    public int getMin() {
        return (int)currMin;
    }
}
