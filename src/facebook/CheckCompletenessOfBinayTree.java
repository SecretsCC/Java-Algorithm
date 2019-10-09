package facebook;

import java.util.LinkedList;
import java.util.Queue;

public class CheckCompletenessOfBinayTree {
    class TreeNode{
        TreeNode left;
        TreeNode right;
        int val;

        public TreeNode() {

        }


    }

    public boolean isCompleteTree(TreeNode root) {
        boolean flag = false;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()) {
            TreeNode node = q.poll();
            if(node == null)
                flag = true;
            else {
                if(flag) return false;
                q.add(node.left);
                q.add(node.right);
            }
        }
        return true;
    }
}
