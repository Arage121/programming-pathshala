//https://leetcode.com/problems/maximal-rectangle/
import java.util.*;
public class MaximumRectangle {
    public int maximalRectangle(char[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        int[][] grid = new int[n][m];

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                grid[i][j] = Character.getNumericValue(matrix[i][j]);
            }
        }

        for(int j=0;j<m;j++){
            for(int i=1;i<n;i++){
                if(grid[i][j] != 0){
                    grid[i][j] = 1+grid[i-1][j];
                }
            }
        }

        int maxArea = 0;
        for(int[] row : grid){ // finding maxArea by comparing maxArea of each row separately
            maxArea = Math.max(maxArea, maxAreaInEachRow(row));
        }

        return maxArea;
    }

    public int maxAreaInEachRow(int[] heights){
        int n = heights.length;
        Stack<Integer> st = new Stack<>();
        int[] nse = new int[n];
        int[] pse = new int[n];

        st.push(0);
        for(int i=1;i<n;i++){
            while(!st.isEmpty() && heights[i] < heights[st.peek()]){
                nse[st.peek()] = i;
                st.pop();
            }
            st.push(i);
        }
        while(!st.isEmpty()){
            nse[st.peek()] = n;
            st.pop();
        }

        st.push(n-1);
        for(int i=n-2;i>=0;i--){
            while(!st.isEmpty() && heights[i] < heights[st.peek()]){
                pse[st.peek()] = i;
                st.pop();
            }
            st.push(i);
        }
        while(!st.isEmpty()){
            pse[st.peek()] = -1;
            st.pop();
        }

        int max = 0;
        for(int i=0;i<n;i++){
            max = Math.max(max, heights[i]*(nse[i]-pse[i]-1));
        }

        return max;
    }
}
