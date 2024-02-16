//https://leetcode.com/problems/palindrome-linked-list/
public class PalindromeLinkedList { // we will reverse the second half of linked list and then compare them accordingly from start and from last
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public boolean isPalindrome(ListNode head) { // O(n) time and constant space complexity
        if(head == null || head.next == null) return true;
        ListNode mid = getMid(head);
        ListNode prev = reverseHalf(mid);
        ListNode curr = head;
        while(curr != null && prev != null){
            if(curr.val != prev.val) return false;
            curr = curr.next;
            prev = prev.next;
        }
        return true;
    }

    public ListNode getMid(ListNode head){
        ListNode sp = head;
        ListNode fp = head;
        while(fp!=null && fp.next!=null){
            sp = sp.next;
            fp = fp.next.next;
        }
        return sp;
    }

    public ListNode reverseHalf(ListNode head){
        ListNode curr = head;
        ListNode prev = null;
        while(curr != null){
            ListNode Next = curr.next;
            curr.next = prev;

            prev = curr;
            curr = Next;
        }
        return prev;
    }
}
