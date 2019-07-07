package LinkedLists;

public class RightShift {
    /**
     *
     * Note that k may be larger than n.
     * if so, it is equivalent to shift by k mod n, so we asssume k < n
     * The key to improve upon the brute-forth approach is to use the fact that linked lists
     * can be cut and the sublists reassembled very efficiently
     * first we find the tail node
     * since the successor of the tail is the original head
     * we update t's successor.
     * The original head is to become the kth node from the start of the new list
     * Therefore, the new head is the (n - k)th node in the initial list
     *
     * @param head
     * @return
     */


    public static ListNode rightShift(ListNode head, int k) {
        if(head == null) return null;

        ListNode tail = head;
        int n = 1;
        while(tail.next != null) {
            ++n;
            tail = tail.next;
        }

        k %= n;
        if(k == 0) return head;

        tail.next = head;
        int stepsToNewHead = n - k;
        ListNode newTail = tail;
        while(stepsToNewHead-- > 0) {
            newTail = newTail.next;
        }
        ListNode newHead = newTail.next;
        newTail.next = null;
        return newHead;
    }
}
