//https://leetcode.com/problems/sudoku-solver/
import java.util.*;
public class SudokuSolverBacktracking {
    public int getMatNum(int i, int j) {
        if (i < 3) {
            if (j < 3) return 0;
            if (j < 6) return 1;
            if (j < 9) return 2;
        }
        if (i < 6) {
            if (j < 3) return 3;
            if (j < 6) return 4;
            if (j < 9) return 5;
        }
        if (i < 9) {
            if (j < 3) return 6;
            if (j < 6) return 7;
        }
        return 8;
    }

    public void ss(int[][] bd, int i, int j, boolean[] ansfound, int[][] rf, int[][] cf, int[][] mf, int[][] ans) {
        if (ansfound[0]) return;
        if (i == 9) {
            ansfound[0] = true;
            for (int p = 0; p < 9; p++) {
                ans[p] = Arrays.copyOf(bd[p], bd[p].length);
            }
            return;
        }
        if (bd[i][j] != 0) {
            if (j < 8) ss(bd, i, j + 1, ansfound, rf, cf, mf, ans);
            else ss(bd, i + 1, 0, ansfound, rf, cf, mf, ans);
            return;
        }
        int matnum = getMatNum(i, j);
        for (int val = 1; val <= 9; val++) {
            if (rf[i][val - 1] == 0 && cf[j][val - 1] == 0 && mf[matnum][val - 1] == 0) {
                bd[i][j] = val;
                rf[i][val - 1] = 1;
                cf[j][val - 1] = 1;
                mf[matnum][val - 1] = 1;
                if (j < 8) ss(bd, i, j + 1, ansfound, rf, cf, mf, ans);
                else ss(bd, i + 1, 0, ansfound, rf, cf, mf, ans);
                bd[i][j] = 0;
                rf[i][val - 1] = 0;
                cf[j][val - 1] = 0;
                mf[matnum][val - 1] = 0;
            }
        }
    }

    public void solveSudoku(char[][] mat) {
        int[][] board = new int[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (mat[i][j] != '.') board[i][j] = mat[i][j] - '0';
            }
        }
        boolean[] ansfound = {false};
        int[][] rf = new int[9][9];
        int[][] cf = new int[9][9];
        int[][] mf = new int[9][9];
        for (int i = 0; i < 9; i++) {
            int[] vec = new int[9];
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != 0) {
                    vec[board[i][j] - 1]++;
                }
            }
            rf[i] = vec.clone();
        }
        for (int j = 0; j < 9; j++) {
            int[] vec = new int[9];
            for (int i = 0; i < 9; i++) {
                if (board[i][j] != 0) {
                    vec[board[i][j] - 1]++;
                }
            }
            cf[j] = vec.clone();
        }
        for (int i = 0; i < 9; i += 3) {
            for (int j = 0; j < 9; j += 3) {
                int[] vec = new int[9];
                for (int i1 = i; i1 < i + 3; i1++) {
                    for (int j1 = j; j1 < j + 3; j1++) {
                        if (board[i1][j1] != 0) {
                            vec[board[i1][j1] - 1]++;
                        }
                    }
                }
                mf[i / 3 * 3 + j / 3] = vec.clone();
            }
        }
        int[][] ans = new int[9][9];
        ss(board, 0, 0, ansfound, rf, cf, mf, ans);
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                mat[i][j] = (char) (ans[i][j] + '0');
            }
        }
    }
}
