//https://leetcode.com/problems/copy-list-with-random-pointer/
import java.util.*;
public class CloneLinkedList { // this is not a normal linked list bcz it has another pointer like next i.e random and this points to any other node
    // and you have to make a clone like this which will have a fully similar structure
    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public Node copyRandomList(Node head) {
        if(head == null) return head;
        Map<Node, Node> map = new HashMap<>();
        Node cloneHead = null;
        Node prev = null;
        Node temp = null;
        Node curr = head;
        while(curr != null){
            temp = new Node(curr.val);
            map.put(curr, temp);
            if(prev == null){
                cloneHead = temp;
                prev = temp;
            }else{
                prev.next = temp;
                prev = temp;
            }
            curr = curr.next;
        }

        Node curr1 = head;
        Node curr2 = cloneHead;
        while(curr1 != null){
            if(curr1.random != null){
                curr2.random = map.get(curr1.random);
            }else{
                curr2.random = null;
            }
            curr1 = curr1.next;
            curr2 = curr2.next;
        }

        return cloneHead;
    }
}
