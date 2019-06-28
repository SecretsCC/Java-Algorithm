package LinkedLists;

public class palindromLinkedlist {
    public static boolean isPalindrome(ListNode head) {
        ListNode afterReverse = copyList(head);
        afterReverse = reverse(afterReverse);

       printList(head);
       System.out.println("----------------------");
       printList(afterReverse);


        while(afterReverse != null && head != null) {
            if(afterReverse.data != head.data) {
                return false;
            }
            afterReverse = afterReverse.next;
            head = head.next;
        }
        return true;

    }

    private static ListNode reverse(ListNode head) {
        ListNode curr = head;
        ListNode prev = null;
        while(curr != null) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }

    private static ListNode copyList(ListNode head) {
        ListNode dummy = new ListNode(0);
        ListNode res = new ListNode(head.data);
        dummy.next = res;
        while(head.next != null) {
            ListNode node = new ListNode(head.next.data);
            res.next = node;
            res = res.next;
            head = head.next;
        }
        return dummy.next;
    }

    private static void printList(ListNode head ) {
        while(head != null) {
            System.out.println(head.data);
            head = head.next;
        }
    }

    public static void main(String args[]) {
        ListNode one = new ListNode(1);
        ListNode two = new ListNode(1);
        ListNode three = new ListNode(2);
        ListNode four = new ListNode(1);

        one.next = two;
        two.next = three;
        three.next = four;
        four.next = null;

        System.out.println(isPalindrome(one));

    }
}
