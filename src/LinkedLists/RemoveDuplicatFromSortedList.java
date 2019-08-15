package LinkedLists;

public class RemoveDuplicatFromSortedList {
    public static ListNode removeDuplicate(ListNode head) {
        ListNode lastDistinctNode = new ListNode(0);
        ListNode res = lastDistinctNode;
        ListNode curr = head;

        while(curr != null && curr.next != null) {
            if(curr.data == curr.next.data) {
                while(curr.next != null && curr.data == curr.next.data) {
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
