package facebook;

import Heap.ListNode;

public class MergeKSortedList {
    class ListNode {
        ListNode next;
        int val;

        public ListNode() {
            this.next = null;
            this.val = 0;
        }

        public ListNode(int val) {
            this.next = null;
            this.val = val;
        }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0) {
            return null;
        }
        return mergeKLists(lists,0,lists.length - 1);
    }

    public ListNode mergeKLists(ListNode[] lists, int left, int right) {
        if(left == right) {
            return lists[left];
        }else if(left < right) {
            int mid = (right - left) / 2 + left;
            ListNode l1 = mergeKLists(lists,left,mid);
            ListNode l2 = mergeKLists(lists,mid + 1, right);
            return merge(l1,l2);
        }
        return null;
    }

    private ListNode merge(ListNode left, ListNode right) {
        if(left == null) return right;
        if(right == null) return left;
        ListNode prehead = new ListNode(-1);
        ListNode prev = prehead;
        while(left != null && right != null) {
            if(left.val <= right.val) {
                prev.next = left;
                left = left.next;
            }else {
                prev.next = right;
                right = right.next;
            }
            prev = prev.next;
        }

        prev.next = left == null ? right : left;

        return prehead.next;
    }
}
