//https://leetcode.com/problems/validate-binary-search-tree/
public class ValidateBinarySearchTree {
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
    public boolean isValidBST(TreeNode root) {
        boolean[] isBst = { true };
        check(root, isBst, Long.MIN_VALUE, Long.MAX_VALUE);
        return isBst[0];
    }

    // lb - lower bound, ub - upper bound
    public void check(TreeNode root, boolean[] isBst, long lb, long ub){
        if(root == null) return;

        if(root.val <= lb || root.val >= ub){
            isBst[0] = false;
            return;
        }

        check(root.left, isBst, lb, (long)root.val);
        check(root.right, isBst, (long)root.val, ub);
    }
}
