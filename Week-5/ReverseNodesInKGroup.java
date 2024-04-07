//https://leetcode.com/problems/reverse-nodes-in-k-group/
public class ReverseNodesInKGroup {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode curr = head;
        int count = 0;
        while(curr != null && count < k){
            count++;
            curr = curr.next;
        }
        if(count < k) return head;

        curr = head;
        ListNode prev = null;
        count = 0;
        while(curr != null && count < k){
            ListNode newNext = curr.next;
            curr.next = prev;

            prev = curr;
            curr = newNext;
            count++;
        }
        head.next = reverseKGroup(curr, k);
        return prev;
    }
}
