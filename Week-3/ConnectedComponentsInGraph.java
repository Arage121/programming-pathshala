//https://hackerearth.com/problem/algorithm/connected-components-in-a-graph/
import java.util.*;
public class ConnectedComponentsInGraph {
    public static void main(String args[] ) throws Exception {
        Scanner sc = new Scanner(System.in);
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int count = 0; // connected component count
        int n = sc.nextInt(); // no. of nodes
        int e = sc.nextInt(); // no. of edges
        for(int i=0;i<=n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<e;i++){
            int u = sc.nextInt();
            int v = sc.nextInt();
            addEdge(adj, u, v);
        }
        int[] visited = new int[n+1];
        for(int i=1;i<=n;i++){
            if(visited[i] != 1){
                count++;
                dfs(adj, visited, i);
            }
        }
        System.out.println(count);
    }

    public static void addEdge(ArrayList<ArrayList<Integer>> adj, int u, int v){ // populating adjacency list
        adj.get(u).add(v); // we have to add to both sides as it is undirectional graph
        adj.get(v).add(u); // i.e pointing to both vertices <-> like this
    }

    public static void dfs(ArrayList<ArrayList<Integer>> adj, int[] visited, int node){
        if(visited[node] == 1) return;
        visited[node] = 1;
        for(int i : adj.get(node)){
            dfs(adj, visited, i);
        }
    }
}
