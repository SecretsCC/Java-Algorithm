package LinkedLists;

public class MergeTwoSortedList {
    public static ListNode<Integer> mergeTwoSortedList(ListNode<Integer> l1, ListNode<Integer> l2) {
        ListNode<Integer> dummyHead = new ListNode<>(0);
        ListNode<Integer> curr = dummyHead;

        while(l1 != null && l2 != null) {
            if(l1.data <= l2.data) {
                curr.next = l1;
                l1 = l1.next;
            }else {
                curr.next = l2;
                l2 = l2.next;
            }
            curr = curr.next;
        }

        curr.next = l1 != null ? l1 : l2;
        return dummyHead.next;
    }

    public static void main(String args[]) {

    }
}
