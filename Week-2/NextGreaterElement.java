//https://www.geeksforgeeks.org/problems/next-larger-element-1587115620/1
import java.util.*;
public class NextGreaterElement {
    //Function to find the next greater element for each element of the array.
    public static long[] nextLargerElement(long[] arr, int n)
    {
        long[] nge = new long[n];
        Stack<Integer> st = new Stack<>();
        st.push(0);
        for(int i=1;i<n;i++){
            while(!st.isEmpty() && arr[i] > arr[st.peek()]){
                nge[st.peek()] = arr[i];
                st.pop();
            }
            st.push(i);
        }

        while(!st.isEmpty()){
            nge[st.pop()] = -1;
        }
        return nge;
    }
}
