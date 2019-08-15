package LinkedLists;

public class RemoveLinkedListElements {
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) return null;
        ListNode pointer = head;
        while (pointer.next != null) {
            if (pointer.next.data == val) pointer.next = pointer.next.next;
            else pointer = pointer.next;
        }
        return head.data == val ? head.next : head;
    }
}
