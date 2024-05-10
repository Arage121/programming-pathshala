//https://www.geeksforgeeks.org/problems/find-a-pair-with-given-target-in-bst/1
import java.util.*;
public class FindPairWithTargetInBST { // used iterative inorder traversal and reverse inorder traversal and then two-pointer approach
    // like in array

    class Node{
        int data;
        Node left, right;
        Node(int data){
            this.data = data;
        }
    }

    public int isPairPresent(Node root, int target)
    {
        if(root == null) return 0;

        Stack<Node> st1 = new Stack<>(); // inorder-traversal stack (i.e sorted)
        Node curr = root;
        while(curr != null){
            st1.push(curr);
            curr = curr.left;
        }

        Stack<Node> st2 = new Stack<>();
        curr = root;
        while(curr != null){
            st2.push(curr); // reverse inorder-traversal stack (i.e reverse sorted)
            curr = curr.right;
        }

        while(st1.peek() != st2.peek()){
            int x = st1.peek().data;
            int y = st2.peek().data;

            if(x+y == target){
                return 1;
            }
            else if(x+y < target){
                Node node = st1.pop();
                Node temp = node.right;
                while(temp != null){
                    st1.push(temp);
                    temp = temp.left;
                }
            }else{
                Node node = st2.pop();
                Node temp = node.left;
                while(temp != null){
                    st2.push(temp);
                    temp = temp.right;
                }
            }
        }

        return 0;
    }
}
