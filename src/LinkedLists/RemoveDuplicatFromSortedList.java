package LinkedLists;

public class RemoveDuplicatFromSortedList {
    public static ListNode removeDuplicate(ListNode head) {
        ListNode lastDistinctNode = new ListNode(0);
        ListNode res = lastDistinctNode;
        ListNode curr = head;

        while(curr != null && curr.next != null) {
            if(curr.val == curr.next.val) {
                while(curr.next != null && curr.val == curr.next.val) {
                    curr = curr.next;
                }
                curr = curr.next;
            }else {
                lastDistinctNode.next = curr;
                lastDistinctNode = curr;
                curr = curr.next;
            }
        }

        lastDistinctNode.next = curr;

        return res.next;
    }

}
