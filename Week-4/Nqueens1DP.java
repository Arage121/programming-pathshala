//https://leetcode.com/problems/n-queens/
import java.util.*;
public class Nqueens1DP { // 2d dp
    public List<List<String>> solveNQueens(int n) {
        char[][] qarr = new char[n][n];
        for(char[] row : qarr){
            Arrays.fill(row, '.');
        }
        return func(qarr, 0);
    }

    public List<List<String>> func(char[][] qarr, int r){
        List<List<String>> result = new ArrayList<>();
        if(r == qarr.length){
            result.add(constructSoln(qarr));
            return result;
        }

        for(int c=0;c<qarr.length;c++){
            if(isSafe(qarr, r, c)){
                qarr[r][c] = 'Q';
                result.addAll(func(qarr, r+1));
                qarr[r][c] = '.';
            }
        }

        return result;
    }

    public boolean isSafe(char[][] qarr, int r, int c){
        for(int i=0;i<r;i++){ // check main column above our supposed 'Q' put place
            if(qarr[i][c] == 'Q') return false;
        }

        for(int i=r,j=c;i>=0 && j>=0;i--,j--){ // checking upper left diagonal
            if(qarr[i][j] == 'Q') return false;
        }

        for(int i = r, j = c; i >= 0 && j < qarr.length; i--, j++){ // checking upper right diagonal
            if(qarr[i][j] == 'Q') return false;
        }

        return true; // any upper two diagonals and same column doesn't have queen placed i.e
        // you can place in this position
    }

    public List<String> constructSoln(char[][] qarr){
        List<String> list = new ArrayList<>();

        for(char[] row : qarr){
            list.add(new String(row));
        }

        return list;
    }
}
