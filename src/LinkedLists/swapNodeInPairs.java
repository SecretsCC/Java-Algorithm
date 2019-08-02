package LinkedLists;

public class swapNodeInPairs {
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode pre = dummy;
        while(pre.next != null && pre.next.next != null) {
            ListNode node1 = pre.next;
            ListNode node2 = pre.next.next;
            ListNode next = node2.next;

            pre.next = node2;
            node2.next = node1;
            node1.next = next;

            pre = node1;
        }

        return dummy.next;

    }
}
