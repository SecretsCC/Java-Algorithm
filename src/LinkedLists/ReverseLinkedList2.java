package LinkedLists;

public class ReverseLinkedList2 {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode preM = dummy;
        ListNode mNode = head;
        ListNode nNode = head;

        for(int i = 1; i < m; ++i) {
            preM = mNode;
            mNode = mNode.next;
        }
        for(int i = 1; i < n; ++i) {
            nNode= nNode.next;
        }

        while(mNode != nNode) {
            preM.next = mNode.next;
            mNode.next = nNode.next;
            nNode.next = mNode;
            mNode = preM.next;
        }

        return dummy.next;


    }
}
