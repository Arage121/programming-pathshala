import java.util.*;
public class ZigZagLevelOrderTraversalOfBinaryTree {
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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) return result;

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int lvl = 0;
        Stack<Integer> st = new Stack<>();

        while(!q.isEmpty()){
            int sz = q.size();
            List<Integer> list = new ArrayList<>();
            while(sz-- > 0){
                TreeNode n = q.peek();
                q.poll();
                if(lvl%2 != 0) st.push(n.val);
                else list.add(n.val);
                if(n.left != null) q.offer(n.left);
                if(n.right != null) q.offer(n.right);
            }
            if(lvl%2 != 0){
                while(!st.isEmpty()){
                    list.add(st.pop());
                }
            }
            lvl++;
            result.add(new ArrayList<>(list));
        }

        return result;
    }
}
