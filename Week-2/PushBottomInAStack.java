import java.util.*;
public class PushBottomInAStack {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack<Integer> st = new Stack<>();
        for(int i=1;i<4;i++){
            st.push(i);
        }
        int x = sc.nextInt(); // the element that should be push bottom in the stack
        // for e.g. if the given stack is like (from bottom to top) -> 1 2 3 then it should be(if 4 is x) -> 4 1 2 3
        pushBottom(x, st);
        while(!st.isEmpty()){
            System.out.print(st.pop() + " ");
        }
    }

    public static void pushBottom(int x, Stack<Integer> st){
        if(st.isEmpty()){
            st.push(x);
            return;
        }
        int a = st.pop();
        pushBottom(x, st);
        st.push(a);
    }
}
