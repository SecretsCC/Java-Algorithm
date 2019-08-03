package LinkedLists;

public class RemoveNthNodeFromEndofList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        int length = 0;
        ListNode curr = head;

        while(curr != null) {
            length++;
            curr = curr.next;
        }

        length = length - n;
        curr = dummy;
        while(length > 0) {
            length--;
            curr = curr.next;
        }

        curr.next = curr.next.next;

        return dummy.next;

    }

    public ListNode removeNthFromEnd2(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode first = dummy;
        ListNode second = dummy;

        for(int i = 0; i <= n; ++i) {
            first = first.next;
        }

        while(first != null) {
            first = first.next;
            second = second.next;
        }

        second.next = second.next.next;

        return dummy.next;


    }
}
