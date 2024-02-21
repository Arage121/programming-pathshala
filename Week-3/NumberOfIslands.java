//https://leetcode.com/problems/number-of-islands/
import java.util.*;
class NumberOfIslands { // you can simply say it like no. of connected components in 2d matrix all the 1 adjacent to each other in 4 directions(up, left, down, right)
    // having 1 beside them connect to each other create one island or connected component
    public class Pair{
        int first;
        int second;
        public Pair(int first, int second){
            this.first = first;
            this.second = second;
        }
    }

    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        List<Pair> directions = List.of(new Pair(-1, 0), new Pair(1, 0), 
                                        new Pair(0, -1), new Pair(0, 1));
        int[][] visited = new int[n][m];
        int count = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(visited[i][j] != 1 && grid[i][j] == '1'){
                    count++;
                    dfs(grid, visited, directions, i, j);
                }
            }
        }
        return count;
    }

    public void dfs(char[][] grid, int[][] visited, List<Pair> directions, int r, int c){ // r-row, c-col
        if(!isValid(grid, visited, r, c)) return;
        if(visited[r][c] == 1) return;
        visited[r][c] = 1;
        for(int i=0;i<directions.size();i++){
            dfs(grid, visited, directions, r+directions.get(i).first, c+directions.get(i).second);
        }
    }

    public boolean isValid(char[][] grid, int[][] visited, int r, int c){
        return r >= 0 && r < grid.length && c >= 0 && c < grid[0].length && grid[r][c] == '1';
    }
}