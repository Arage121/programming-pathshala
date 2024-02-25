//https://leetcode.com/problems/unique-paths-iii/
public class UniquePaths3UsingBacktracking {
    public class Pair{
        int first;
        int second;
        Pair(int first, int second){
            this.first = first;
            this.second = second;
        }
    }

    public int uniquePathsIII(int[][] grid) {
        Pair p = findSrc(grid);
        return countPaths(grid, p.first, p.second);
    }

    public Pair findSrc(int[][] grid){
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j] == 1) return new Pair(i, j);
            }
        }
        return new Pair(-1, -1);
    }

    public int countPaths(int[][] grid, int i, int j){
        if(grid[i][j] == 2){
            return isAllVisited(grid) ? 1 : 0; // every cell should be visited once to get one path
        }
        grid[i][j] = -1; // marking visited
        int sum = 0;
        if(isValid(grid, i, j+1)){
            sum += countPaths(grid, i, j+1); // move right
        }
        if(isValid(grid, i, j-1)){
            sum += countPaths(grid, i, j-1); // move left
        }
        if(isValid(grid, i-1, j)){
            sum += countPaths(grid, i-1, j); // move top
        }
        if(isValid(grid, i+1, j)){
            sum += countPaths(grid, i+1, j); // move bottom
        }
        grid[i][j] = 0; // backtracking
        return sum;
    }

    public boolean isValid(int[][] grid, int i,  int j){
        return i >= 0 && i < grid.length && j >=0 && j < grid[0].length && grid[i][j] != -1;
    }

    public boolean isAllVisited(int[][] grid){
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 0) return false; // Found an unvisited cell
            }
        }
        return true; // All cells except obstacles are visited
    }
}
