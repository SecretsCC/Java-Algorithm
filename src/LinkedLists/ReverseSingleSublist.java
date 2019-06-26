package LinkedLists;

public class ReverseSingleSublist {

    public static ListNode reverseSublist(ListNode head, int start, int end) {
        if (start == end) return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode sublistHead = dummy;

        int k = 1;
        while (k++ < start) {
            sublistHead = sublistHead.next;
        }

        ListNode sublistStart = sublistHead.next;
        while (start++ < end) {
            ListNode temp = sublistStart.next;
            sublistStart.next = temp.next;
            temp.next = sublistHead.next;
            sublistHead.next = temp;
        }
        return dummy.next;
    }
}
