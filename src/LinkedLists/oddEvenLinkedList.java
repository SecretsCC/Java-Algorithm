package LinkedLists;

public class oddEvenLinkedList {
    public ListNode oddEvenList(ListNode head) {
        ListNode oddHead = new ListNode(0);
        ListNode odd = oddHead;
        ListNode evenHead = new ListNode(0);
        ListNode even = evenHead;

        int index = 1;
        while(head != null) {
            if(index % 2 != 0) {
                odd.next = head;
                odd = odd.next;
            }else {
                even.next = head;
                even = even.next;
            }
            head = head.next;
            index++;
        }

        even.next = null;
        odd.next = evenHead.next;

        return oddHead.next;
    }
}
