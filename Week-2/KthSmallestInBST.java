public class KthSmallestInBST { // bst is like sorted array binary search version ex like everything left of mid element is smaller than it, and everything
    // right to it is greater than it and in in Binary Search Tree root acts like middle element
    // In this question we have used Inorder traversal of tree because it is more efficient for BST question, as the question states we have to find the Kth
    // smallest element in the tree so as Inorder-> Left Root Right so we will get sorted values from small to greater and we will only traverse till our count
    // reaches the kth value
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
    public int kthSmallest(TreeNode root, int k) {
        int[] ans = new int[1];
        findKthSmallest(root, k, new int[]{1}, ans);
        return ans[0];
    }

    public void findKthSmallest(TreeNode root, int k, int[] count, int[] ans){ // using inorder traversal
        if(root == null) return;
        findKthSmallest(root.left, k, count, ans);
        if(count[0]++ == k){
            ans[0] = root.val;
            return;
        }
        findKthSmallest(root.right, k, count, ans);
    }
}
