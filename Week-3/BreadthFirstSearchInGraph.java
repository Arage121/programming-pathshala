//https://www.geeksforgeeks.org/problems/bfs-traversal-of-graph/1
import java.util.*;
public class BreadthFirstSearchInGraph {
    // Function to return Breadth First Traversal of given graph.
    public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> list = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        int[] visited = new int[V+1];
        q.offer(0);
        visited[0] = 1;
        while(!q.isEmpty()){
            int x = q.poll();
            list.add(x);
            for(int i=0;i<adj.get(x).size();i++){
                if(visited[adj.get(x).get(i)] == 1){
                    continue;
                }else{
                    visited[adj.get(x).get(i)] = 1;
                    q.offer(adj.get(x).get(i));
                }
            }
        }
        return list;
    }
}
