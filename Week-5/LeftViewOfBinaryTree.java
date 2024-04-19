//https://www.geeksforgeeks.org/problems/left-view-of-binary-tree/1
import java.util.*;
public class LeftViewOfBinaryTree { // without using any extra space
    //Function to return list containing elements of left view of binary tree.
    class Node
    {
        int data;
        Node left, right;

        Node(int item)
        {
            data = item;
            left = right = null;
        }
    }
    int maxLvl = -1;
    ArrayList<Integer> leftView(Node root)
    {
        ArrayList<Integer> list = new ArrayList<>();
        allLefts(list, root, 0);
        return list;
    }

    void allLefts(ArrayList<Integer> list, Node root, int lvl){
        if(root == null) return;
        if(lvl > maxLvl){
            maxLvl = lvl;
            list.add(root.data);
        }

        allLefts(list, root.left, lvl+1);
        allLefts(list, root.right, lvl+1);
    }
}
