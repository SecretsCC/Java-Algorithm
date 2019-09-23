package facebook;

import java.util.ArrayList;
import java.util.List;

public class ConvertBinarySearchTreetoSortedDoublyLinkedList {

    class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {}

        public Node(int _val,Node _left,Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    };

    List<Node> list = new ArrayList<>();

    public Node treeToDoublyList(Node root) {
        if(root == null) return root;

        inorder(root);

        Node head = list.get(0);
        Node curr = head;


        for(int i = 1; i < list.size(); ++i) {
            Node next = list.get(i);
            curr.right = next;
            next.left = curr;
            curr = next;
        }
        head.left = curr;
        curr.right = head;

        return head;

    }

    private void inorder(Node root) {
        if(root == null) return;

        inorder(root.left);
        list.add(root);
        inorder(root.right);
    }
}
