package LinkedLists;

public class DeleteLastKNodes {
    public static ListNode deleteLastKNodes(ListNode l, int k) {
        ListNode dummy = new ListNode(0);
        dummy.next = l;
        ListNode kfirst = dummy.next;

        while(k-- > 0) {
            kfirst = kfirst.next;
        }

        ListNode second = dummy;
        while(kfirst != null) {
            kfirst = kfirst.next;
            second = second.next;
        }
        second.next = second.next.next;
        return dummy.next;
    }
}
