//https://www.geeksforgeeks.org/problems/min-distance-between-two-given-nodes-of-a-binary-tree/1
public class MinDistanceBetweenTwoNodes { // using the LCA ( lowest common ancestor approach )
    class Node{
        int data;
        Node left, right;
        Node(int item){
            this.data = item;
            this.left = this.right = null;
        }
    }
    int findDist(Node root, int a, int b) {
        Node node = lca(root, a, b);
        int[] levels = new int[3];
        traverse(root, 0, node, a, b, levels);
        int dist = (levels[1]+levels[2]) - 2*levels[0];
        return dist;
    }

    void traverse(Node root, int lvl, Node lca, int a, int b, int[] levels){
        if(root == null) return;
        if(root == lca) levels[0] = lvl;
        if(root.data == a) levels[1] = lvl;
        if(root.data == b) levels[2] = lvl;

        traverse(root.left, lvl+1, lca, a, b, levels);
        traverse(root.right, lvl+1, lca, a, b, levels);
    }

    Node lca(Node root, int a, int b){
        if(root == null) return root;
        if(root.data == a || root.data == b) return root;

        Node lst = lca(root.left, a, b);
        Node rst = lca(root.right, a, b);

        if(lst != null && rst != null) return root;
        if(lst != null) return lst;
        if(rst != null) return rst;

        return null;
    }
}
