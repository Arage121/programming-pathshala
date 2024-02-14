//https://leetcode.com/problems/largest-rectangle-in-histogram/
import java.util.*;
public class LargestRectangleHistogram { // used nextGreaterElement logic
    public int largestRectangleArea(int[] heights) { // O(n) approach for both time and space complexity
        int n = heights.length;
        int[] nse = new int[n]; // next smallest element of that index element
        int[] pse = new int[n]; // previous smallest element of that index element
        Stack<Integer> st = new Stack<>(); // this will store the index values

        // first for nse
        st.push(0);
        for(int i=1;i<n;i++){
            while(!st.isEmpty() && heights[i] < heights[st.peek()]){
                nse[st.pop()] = i; // for that element nse is at i index and then we will pop the
                // element in stack
            }
            st.push(i); // and if it's not small we will simply push the elments till we do not find
            //the next smaller element
        }

        while(!st.isEmpty()){
            nse[st.pop()] = n; // if stack has left some elements that means, for that elements
            // we weren't able to find any next smaller element so we will simply make their value
            // equal to the length of arr
        }

        // now st stack is empty we will use the same stack for pse also

        // second for pse (starting from last as it's previous smallest element)
        st.push(n-1);
        for(int i=n-2;i>=0;i--){
            while(!st.isEmpty() && heights[i] < heights[st.peek()]){
                pse[st.pop()] = i;
            }
            st.push(i); // all the same reason as above nse
        }

        while(!st.isEmpty()){
            pse[st.pop()] = -1;
        }

        // Main part and logic for finding largest area of rectangle

        int maxArea = Integer.MIN_VALUE;

        for(int i=0;i<n;i++){ // here (nse[i]-pse[i]-1) is breadth and heights[i] is height of rectangle
            maxArea = Math.max(maxArea, heights[i]*(nse[i]-pse[i]-1));
            // as area of rectangle = l*b
        }

        return maxArea;
    }
}
