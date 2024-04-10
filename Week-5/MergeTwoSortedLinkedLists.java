//https://leetcode.com/problems/merge-two-sorted-lists/
public class MergeTwoSortedLinkedLists {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) { // iterative
        ListNode curr = new ListNode(Integer.MIN_VALUE);
        ListNode head = curr;

        while(list1 != null && list2 != null){
            if(list1.val <= list2.val){
                curr.next = list1;
                list1 = list1.next;
            }else{
                curr.next = list2;
                list2 = list2.next;
            }
            curr = curr.next;
        }

        if(list1 == null){
            curr.next = list2;
        }else if(list2 == null){
            curr.next = list1;
        }

        return head.next;
    }
}
