package Heap;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MergeKSortedList {
    public static ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for(int i = 0; i < lists.length; ++i) {
            ListNode curr = lists[i];
            while(curr != null) {
                heap.add(curr.val);
                printHeap(heap);
                curr = curr.next;
            }
        }

        ListNode dummy = new ListNode(0);
        ListNode res = dummy;
        for(int i : heap) {
            ListNode tmp = new ListNode(i);
            res.next = tmp;
            res = res.next;
        }

        return dummy.next;
    }

    private static void printHeap(PriorityQueue heap) {
        System.out.print(Arrays.toString(heap.toArray()));
    }



    public static void main(String args[]) {
        ListNode[] lists = new ListNode[3];
    }
}
