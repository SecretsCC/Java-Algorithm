package LinkedLists;

public class Palindrom2 {
    public static boolean testPalindrom(ListNode head) {
        if(head == null) {
            return true;
        }

        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        ListNode firstHalfIter = head;
        ListNode secondHalfIter = ReverseLinkedList.reverse(slow);
        while(secondHalfIter != null && firstHalfIter != null) {
            if (secondHalfIter.data != firstHalfIter.data) {
                return false;
            }
            secondHalfIter = secondHalfIter.next;
            firstHalfIter = firstHalfIter.next;
        }
        return true;
    }
}
