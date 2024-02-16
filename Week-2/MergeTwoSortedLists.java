public class MergeTwoSortedLists { // both recursive and iterative approach
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // if(list1 == null) return list2;  // iterative approach
        // if(list2 == null) return list1;
        // ListNode head = null, tail = null;
        // ListNode p1 = list1, p2 = list2;
        // if(p1.val <= p2.val){
        //     head = list1; tail = list1; p1 = p1.next;
        // }else{
        //     head = list2; tail = list2; p2 = p2.next;
        // }

        // while(p1!=null && p2!=null){
        //     if(p1.val <= p2.val){
        //         tail.next = p1;
        //         p1 = p1.next;
        //     }else{
        //         tail.next = p2;
        //         p2 = p2.next;
        //     }
        //     tail = tail.next;
        // }

        // if(p1 == null){
        //     tail.next = p2;
        // }else{
        //     tail.next = p1;
        // }
        // return head;

        if(list1 == null) return list2;  // recursive approach
        if(list2 == null) return list1;
        ListNode head = null, curr = null;
        if(list1.val <= list2.val){
            head = list1;
            curr = head.next;
            head.next = null;
            head.next = mergeTwoLists(curr, list2);
        }else{
            head = list2;
            curr = head.next;
            head.next = null;
            head.next = mergeTwoLists(list1, curr);
        }
        return head;
    }
}
