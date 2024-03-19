//https://leetcode.com/problems/sum-of-subarray-minimums/
import java.util.*;
public class SumOfSubArrMin {
    public int sumSubarrayMins(int[] arr) {
        int n = arr.length;
        int ans = 0;
        int MOD = 1000000007;

        Stack<Integer> st = new Stack<>();

        int[] nse = new int[n];
        st.push(0);
        for(int i=1;i<n;i++){
            while(!st.isEmpty() && arr[i] < arr[st.peek()]){
                nse[st.peek()] = i;
                st.pop();
            }
            st.push(i);
        }
        while(!st.isEmpty()){
            nse[st.peek()] = n;
            st.pop();
        }

        int[] pse = new int[n];
        st.push(n-1);
        for(int i=n-2;i>=0;i--){
            while(!st.isEmpty() && arr[i] <= arr[st.peek()]){
                pse[st.peek()] = i;
                st.pop();
            }
            st.push(i);
        }
        while(!st.isEmpty()){
            pse[st.peek()] = -1;
            st.pop();
        }

        for(int i=0;i<n;i++){
            int contr = (int)((long)((i-pse[i])%MOD * (nse[i]-i)%MOD)%MOD * arr[i]%MOD)%MOD;
            ans = (ans%MOD + contr%MOD)%MOD;
        }

        return ans;
    }
}
