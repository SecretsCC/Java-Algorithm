package LinkedLists;

public class TestForOverlappingLists {
    public static ListNode overlapping(ListNode l1, ListNode l2) {
        int l1Length = length(l1);
        int l2length = length(l2);

        if(l1Length > l2length) {
            l1 = advanceListByK(l1Length - l2length, l1);
        }else {
            l2 = advanceListByK(l2length - l1Length, l2);
        }

        while(l1 != null && l2 != null && l1 != l2) {
            l1 = l1.next;
            l2 = l2.next;
        }
        return l1;


    }

    private static ListNode advanceListByK(int k, ListNode l) {
        while(k-- > 0) {
            l = l.next;
        }
        return l;
    }

    private static int length(ListNode l) {
        int len = 0;
        while(l != null) {
            ++len;
            l = l.next;
        }
        return len;
    }
}
