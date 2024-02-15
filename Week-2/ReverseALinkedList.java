public class ReverseALinkedList { // both iterative and recursive approach
      public class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
      }
    public ListNode reverseList(ListNode head) {
        // ListNode curr = head;  // iterative approach
        // ListNode prev = null;
        // while(curr != null){
        //     ListNode newNext = curr.next;
        //     curr.next = prev;

        //     prev = curr;
        //     curr = newNext;
        // }
        // return prev;

        // recursive approach below
        if(head == null || head.next == null) return head;
        ListNode temp = head.next;
        head.next = null;
        ListNode newHead = reverseList(temp);
        temp.next = head;
        return newHead;
    }
}
