//https://www.geeksforgeeks.org/problems/depth-first-traversal-for-a-graph/1
import java.util.*;
public class DepthFirstSearchInGraph { // dfs is basically a recursive approach and it goes for one node till it has visited all its neighbors
    // Function to return a list containing the DFS traversal of the graph.
    public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> list = new ArrayList<>();
        int[] visited = new int[V+1];
        dfs(adj, list, visited, 0);
        return list;
    }

    public void dfs(ArrayList<ArrayList<Integer>> adj, ArrayList<Integer> list, int[] visited, int node){
        if(visited[node] == 1) return;
        visited[node] = 1;
        list.add(node);
        for(int i : adj.get(node)){
            dfs(adj, list, visited, i);
        }
    }
}
