package facebook;

import java.util.ArrayList;
import java.util.List;

public class BSTIterator {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }

    List<Integer> nodesSorted;
    int index;

    public BSTIterator(TreeNode root) {
        this.nodesSorted = new ArrayList<>();
        this.index = -1;
        this._inorder(root);
    }

    private void _inorder(TreeNode root) {
        if(root == null)
            return;

        this._inorder(root.left);
        this.nodesSorted.add(root.val);
        this._inorder(root.right);
    }

    /** @return the next smallest number */
    public int next() {
        return this.nodesSorted.get(++this.index);
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return this.index + 1 < this.nodesSorted.size();
    }
}
