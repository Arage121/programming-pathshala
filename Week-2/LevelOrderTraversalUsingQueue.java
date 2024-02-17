//https://leetcode.com/problems/binary-tree-level-order-traversal/
import java.util.*;
public class LevelOrderTraversalUsingQueue { // iterative approach
    public class TreeNode { // we are pushing each level nodes and then popping them from left to right and at each pop adding the childrens of them in queue
        // time complexity will be O(N) and space will be O(w) where w is max width of binary tree
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) return result;
        Queue<TreeNode> q = new LinkedList<>();
        levelOrderUsingQueue(root, q, result);
        return result;
    }

    public void levelOrderUsingQueue(TreeNode root, Queue<TreeNode> q, List<List<Integer>> result){
        if(root == null) return;
        q.offer(root);
        while(!q.isEmpty()){
            int size = q.size();
            List<Integer> list = new ArrayList<>();
            while(size-- > 0){
                TreeNode front = q.poll();
                list.add(front.val);
                if(front.left != null) q.offer(front.left);
                if(front.right != null) q.offer(front.right);
            }
            result.add(list);
        }
    }
}
