//https://leetcode.com/problems/n-queens-ii/
public class Nqueens2DP { // 2d dp
    public int totalNQueens(int n) {
        int[][] arr = new int[n][n];
        int[] count = new int[1];
        func(arr, count, 0);
        return count[0];
    }

    public void func(int[][] arr, int[] count, int r){
        if(r == arr.length){
            count[0]++;
            return;
        }

        for(int c=0;c<arr.length;c++){
            if(isSafe(arr, r, c)){
                arr[r][c] = 1;
                func(arr, count, r+1);
                arr[r][c] = 0;
            }
        }
    }

    public boolean isSafe(int[][] arr, int r, int c){
        int n = arr.length;
        for(int i=0;i<r;i++){
            if(arr[i][c] == 1) return false;
        }

        for(int i=r,j=c;i>=0&&j>=0;i--,j--){
            if(arr[i][j] == 1) return false;
        }

        for(int i=r,j=c;i>=0&&j<n;i--,j++){
            if(arr[i][j] == 1) return false;
        }

        return true;
    }
}
