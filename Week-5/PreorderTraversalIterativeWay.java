//https://leetcode.com/problems/binary-tree-preorder-traversal/
import java.util.*;
public class PreorderTraversalIterativeWay { // using stack ( as in recursion also internally it's using call stack only for mutliple functions )
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    public List<Integer> preorderTraversal(TreeNode root) { // iterative way
        List<Integer> list = new ArrayList<>();
        if(root == null) return list;

        Stack<TreeNode> st = new Stack<>();
        st.push(root);
        while(!st.isEmpty()){
            TreeNode node = st.peek();
            st.pop();
            list.add(node.val);

            if(node.right != null) st.push(node.right);
            if(node.left != null) st.push(node.left);
        }

        return list;
    }
}
