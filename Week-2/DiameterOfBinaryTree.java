//https://leetcode.com/problems/diameter-of-binary-tree/
public class DiameterOfBinaryTree {
    public class TreeNode {
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
    class Pair{ // second approach
        int h; // height
        int d; // diameter
        Pair(int h, int d){
            this.h = h;
            this.d = d;
        }
    }
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        return getHeight(root).d;
        // int[] ans = new int[1]; // second approach
        // getHeight(root, ans);
        // return ans[0];
    }

    // public int getHeight(TreeNode root, int[] ans) { // first approach
    //     if (root == null) return 0;

    //     int leftHeight = getHeight(root.left, ans);
    //     int rightHeight = getHeight(root.right, ans);

    //     ans[0] = Math.max(ans[0], leftHeight + rightHeight);

    //     return 1 + Math.max(leftHeight, rightHeight);
    // }

    public Pair getHeight(TreeNode root){ // second approach
        if(root == null) return new Pair(0, 0);

        Pair lst = getHeight(root.left); // lst-left side tree, rst-left side tree
        Pair rst = getHeight(root.right);

        int h = 1+Math.max(lst.h, rst.h);
        int d = Math.max((lst.h+rst.h), Math.max(lst.d, rst.d));

        return new Pair(h, d);
    }
}
