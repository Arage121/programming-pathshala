//https://leetcode.com/problems/binary-tree-paths/
import java.util.*;
public class BinaryTreeAllPathsFromRootToLeaf {
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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        List<Integer> vector = new ArrayList<>();
        if(root == null) return result;
        rootToLeafPaths(root, vector, result);
        return result;
    }

    public void rootToLeafPaths(TreeNode root, List<Integer> vector, List<String> result){
        if(root == null) return;
        vector.add(root.val);
        if(root.left == null && root.right == null){ // leaf node
            StringBuilder sb = new StringBuilder();
            for(int i=0;i<vector.size();i++){
                sb.append(Integer.toString(vector.get(i)));
                if(i<vector.size()-1){
                    sb.append("->");
                }
            }
            result.add(sb.toString());
        }else{
            rootToLeafPaths(root.left, vector, result);
            rootToLeafPaths(root.right, vector, result);
        }
        vector.remove(vector.size()-1); // backtracking
    }
}
