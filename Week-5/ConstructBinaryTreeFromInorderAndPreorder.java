//https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
import java.util.*;
public class ConstructBinaryTreeFromInorderAndPreorder { // building tree from start with help of preorder and inorder traversals
    class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right){
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) { // 2nd approach optimized using hashmap now it's only O(N)
        int n = preorder.length, m = inorder.length;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<m;i++){
            map.put(inorder[i], i);
        }
        return build(map, preorder, inorder, 0, n-1, 0, m-1);
    }

    public TreeNode build(Map<Integer, Integer> map, int[] preorder, int[] inorder, int i1, int j1, int i2, int j2){
        if(i1 > j1) return null;

        TreeNode root = new TreeNode(preorder[i1]);

        int i = map.get(preorder[i1]);

        root.left = build(map, preorder, inorder, i1+1, i1+i-i2, i2, i-1);
        root.right = build(map, preorder, inorder, i1+i-i2+1, j1, i+1, j2);

        return root;
    }

//    public TreeNode buildTree(int[] preorder, int[] inorder) { // 1st approach it has O(N^2)
//        int n = preorder.length, m = inorder.length;
//        return build(preorder, inorder, 0, n-1, 0, m-1);
//    }
//
//    public TreeNode build(int[] preorder, int[] inorder, int i1, int j1, int i2, int j2){
//        if(i1 > j1) return null;
//
//        TreeNode root = new TreeNode(preorder[i1]);
//
//        int i = 0;
//        for(i=i2;i<=j2;i++){
//            if(inorder[i] == preorder[i1]) break;
//        }
//
//        root.left = build(preorder, inorder, i1+1, i1+i-i2, i2, i-1);
//        root.right = build(preorder, inorder, i1+i-i2+1, j1, i+1, j2);
//
//        return root;
//    }
}
