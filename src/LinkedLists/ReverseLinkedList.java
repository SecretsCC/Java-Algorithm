package LinkedLists;

public class ReverseLinkedList {
    public static ListNode reverse(ListNode Head) {
        ListNode prev = null;
        ListNode curr = Head;
        while(curr != null) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }
}
