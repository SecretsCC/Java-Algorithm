package LinkedLists;

public class AddTwoNumber {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode res = new ListNode(0);
        ListNode dummy = res;

        int plus = 0;

        while(l1 != null || l2 != null) {
            int x1 = l1 == null ? 0 : l1.data;
            int x2 = l2 == null ? 0 : l2.data;
            int sum = x1 + x2 + plus;

            plus = (sum) / 10;
            sum = sum % 10;

            ListNode tmp = new ListNode(sum);
            res.next = tmp;
            res = res.next;
            if(l1 != null) l1 = l1.next;
            if(l2 != null) l2 = l2.next;
        }

        if(plus == 1) {
            ListNode tail = new ListNode(1);
            res.next = tail;
        }

        return dummy.next;
    }
}
