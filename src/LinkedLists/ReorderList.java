package LinkedLists;

public class ReorderList {
    public void reorderList(ListNode head) {
        if(head == null) return;
        ListNode mid = findMid(head);
        ListNode l2 = mid.next;
        mid.next = null;
        l2 = reverse(l2);
        ListNode l1 = head;
        while(l1 != null && l2 != null ) {
            ListNode next = l1.next;
            l1.next = l2;
            l2 = l2.next;
            l1.next.next = next;
            l1 = next;
        }
    }


    public ListNode findMid(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    public ListNode reverse(ListNode head) {
        ListNode pre = null;
        ListNode curr = head;
        while(curr != null) {
            ListNode tmp = curr.next;
            curr.next = pre;
            pre = curr;
            curr = tmp;
        }
        return pre;
    }
}
