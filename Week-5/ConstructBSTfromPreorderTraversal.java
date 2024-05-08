//https://leetcode.com/problems/construct-binary-search-tree-from-preorder-traversal/
import java.util.*;
public class ConstructBSTfromPreorderTraversal { // we have been given preorder traversal of bst and we have to create the exact bst referred to it
    class TreeNode{
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
    public TreeNode bstFromPreorder(int[] preorder) { // we are using next greater element approach and solving this problem according to it
        int n = preorder.length;                      // once we find nge of the root then we can divide it accordingly ( because this is a bst i.e all the
        if(n == 0) return null;                       // left hand side will be less than the root, and right will be greater

        int[] nge = new int[n];
        Stack<Integer> st = new Stack<>();
        st.push(0);

        for(int i=1;i<n;i++){
            while(!st.isEmpty() && preorder[i] > preorder[st.peek()]){
                nge[st.peek()] = i;
                st.pop();
            }
            st.push(i);
        }

        while(!st.isEmpty()){
            nge[st.peek()] = n;
            st.pop();
        }

        return makeBst(preorder, 0, n-1, nge);
    }

    public TreeNode makeBst(int[] preorder, int i, int j, int[] nge){
        if(i > j) return null;

        TreeNode root = new TreeNode(preorder[i]);

        root.left = makeBst(preorder, i+1, nge[i]-1, nge);
        root.right = makeBst(preorder, nge[i], j, nge);

        return root;
    }
}
