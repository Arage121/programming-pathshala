//https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/
public class LowestCommonAncestorOfBT {
    class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) { this.val = val; }
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return null;

        if(root == p || root == q) return root;

        TreeNode lst = lowestCommonAncestor(root.left, p, q);
        TreeNode rst = lowestCommonAncestor(root.right, p, q);

        if(lst != null && rst != null) return root; // If p and q are in different subtrees, return root
        if(lst != null) return lst;
        if(rst != null) return rst;

        return null; // If neither p nor q found
    }
}
