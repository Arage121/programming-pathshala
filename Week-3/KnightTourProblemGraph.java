//https://dashboard.programmingpathshala.com/renaissance/homepage/lecture?subtopic=368&sequence=14
import java.sql.Array;
import java.util.*;
public class KnightTourProblemGraph { // we are not separately using graph but using its logic like bfs
    public class Cell{
        int row;
        int col;
        int dist;
        public Cell(int row, int col, int dist){
            this.row = row;
            this.col = col;
            this.dist = dist;
        }
    }

    public class Pair{
        int first;
        int second;
        public Pair(int first, int second){
            this.first = first;
            this.second = second;
        }
    }

    public void findTotalNoOfStepsFromSrcToDestination(Pair dest, Pair src, int n){ // a knight is like a horse in chess 2 steps in one direction
        // and one in perpendicular to the previous one
        List<Pair> directions = List.of(new Pair(2, 1), new Pair(2, -1), new Pair(-2, 1), new Pair(-2, -1),
                                        new Pair(1, 2), new Pair(1, -2), new Pair(-1, 2), new Pair(-1, -2));
        Queue<Cell> q = new LinkedList<>();
        int visited[][] = new int[n][n];
        visited[src.first][src.second] = 1;
        q.offer(new Cell(src.first, src.second, 0));
        while(!q.isEmpty()){
            Cell x = q.poll();
            if(x.row == dest.first && x.col == dest.second){
                System.out.println(x.dist);
                break;
            }

            for(int i=0;i<directions.size();i++){
                Cell adj = new Cell(x.row+directions.get(i).first, x.col+directions.get(i).second, x.dist+1);
                if(!isVaild(adj, n)) continue;
                if(visited[adj.row][adj.col] != 1){
                    visited[adj.row][adj.col] = 1;
                    q.offer(adj);
                }
            }
        }
    }

    public boolean isVaild(Cell c, int n){
        return c.row >= 0 && c.row < n && c.col >=0 && c.col < n;
    }
}
