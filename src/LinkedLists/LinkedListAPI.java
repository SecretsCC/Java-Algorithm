package LinkedLists;

import java.util.List;

class ListNode<T> {
    public int data;
    public ListNode<T> next;

    public ListNode(int a) {
        this.data = a;
        this.next = null;
    }

    public static ListNode<Integer> search(ListNode<Integer> L, int key) {
        while(L != null && L.data != key) {
            L = L.next;
        }
        //if key was not present in the list, L will have become null;
        return L;
    }

    public static void insertAfter(ListNode<Integer> node, ListNode<Integer> newNode) {
        newNode.next = node.next;
        node.next = newNode;
    }

    public static void deleteList(ListNode<Integer> aNode) {
        aNode.next = aNode.next.next;
    }
}

class test {
    public static void main(String args[]) {
        ListNode<Integer> a = new ListNode<>(1);
        ListNode<Integer> b = new ListNode<>(2);
        a.next = b;
        while(a != null) {
            System.out.println(a.data);
            a = a.next;
        }
    }
}





