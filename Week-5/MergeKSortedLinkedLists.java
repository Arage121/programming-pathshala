//https://leetcode.com/problems/merge-k-sorted-lists/
public class MergeKSortedLinkedLists {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0) return null;
        return mergeK(lists, 0, lists.length-1);
    }

    public ListNode mergeK(ListNode[] lists, int i, int j){
        if(i == j) return lists[i];
        int m = i+(j-i)/2;
        ListNode first = mergeK(lists, i, m);
        ListNode second = mergeK(lists, m+1, j);
        return merge(first, second);
    }

    public ListNode merge(ListNode list1, ListNode list2){ // iterative
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
