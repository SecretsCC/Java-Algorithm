package LinkedLists;

public class overlapAndCycle {
    public static ListNode overlappingList(ListNode l1, ListNode l2) {

        ListNode root1 = testCycle(l1);
        ListNode root2 = testCycle(l2);

        if(root1 == null && root2 == null) {
            return null;
        }else if ((root1 != null && root2 == null) || (root1 == null && root2 != null)) {
            return null;
        }

        ListNode temp = root2;
        do{
            temp = temp.next;
        }while(temp != root1 && temp != root2);

        if(temp != root1) {
            return null;
        }

        int stem1Length = distance(l1, root1);
        int stem2Length = distance(l2, root2);
        int count = Math.abs(stem1Length - stem2Length);
        if(stem1Length > stem2Length) {
            l1 = advanceListByK(stem1Length - stem2Length, l1);
        }else {
            l2 = advanceListByK(stem2Length - stem1Length, l2);
        }

        while(l1 != l2 && l1 != root1 && l2 != root2) {
            l1 = l1.next;
            l2 = l2.next;
        }

        return l1 == l2 ? l1 : root1;
    }

    private static ListNode testCycle(ListNode l) {
        if(l == null) return null;
        ListNode slow = l;
        ListNode fast = l.next;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast) {
                ListNode iter = l;
                while(iter != slow) {
                    iter = iter.next;
                    slow = slow.next;
                }
                return iter;
            }
        }
        return null;
    }

    private static int distance(ListNode a, ListNode b) {
        int len  = 0;
        while(a != b) {
            len++;
            a = a.next;
        }
        return len;
    }

    private static ListNode advanceListByK(int a, ListNode l) {
        while(a-- > 0) {
            l = l.next;
        }
        return l;
    }
}
