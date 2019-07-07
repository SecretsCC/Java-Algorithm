package LinkedLists;

public class RemoveDuplicatesFromSortedList {
    public static ListNode removeDuplicate(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        while(head != null) {
            ListNode nextDistingct = head.next;
            while(nextDistingct != null && head.data == nextDistingct.data) {
                nextDistingct = nextDistingct.next;
            }
            head.next = nextDistingct;
            head = nextDistingct;
        }

        return dummy.next;
    }
}
