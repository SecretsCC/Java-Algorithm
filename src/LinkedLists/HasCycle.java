package LinkedLists;

public class HasCycle {
    public static ListNode hasCycle(ListNode head) {
        ListNode fast = head, slow = head;

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) {
                int cyclen = 0;
                do {
                    ++cyclen;
                    fast = fast.next;
                }while(slow != fast);

                ListNode cycleLenAdvance = head;
                while(cyclen-- > 0) {
                    cycleLenAdvance = cycleLenAdvance.next;
                }

                ListNode iter = head;
                while(iter != cycleLenAdvance) {
                    iter = iter.next;
                    cycleLenAdvance = cycleLenAdvance.next;
                }
                return iter;
            }
        }
        return null;
    }
}
