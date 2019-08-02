package LinkedLists;

public class AddTwoNumbers2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();

        while(l1 != null) {
            stack1.push(l1.val);
            l1 = l1.next;
        }

        while(l2 != null) {
            stack2.push(l2.val);
            l2 = l2.next;
        }

        ListNode dummy = null;

        int plus = 0;
        while(!stack1.isEmpty() || !stack2.isEmpty()) {
            int x1 = 0;
            int x2 = 0;
            if(!stack1.isEmpty()) {
                x1 = stack1.pop();
            }else{
                x1 = 0;
            }

            if(!stack2.isEmpty()) {
                x2 = stack2.pop();
            }else{
                x2 = 0;
            }

            int sum = x1 + x2 + plus;
            plus = sum/10;
            sum = sum % 10;

            ListNode tmp = new ListNode(sum);
            tmp.next = dummy;
            dummy = tmp;

        }

        if(plus == 1) {
            ListNode head = new ListNode(1);
            head.next = dummy;
            dummy = head;
        }
        return dummy;
    }
}
