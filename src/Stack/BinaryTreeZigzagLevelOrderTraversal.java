package Stack;

import java.util.LinkedList;
import java.util.List;

public class BinaryTreeZigzagLevelOrderTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        LinkedList<TreeNode> q = new LinkedList<>();
        if(root == null) return res;

        q.add(root);
        int oddEven = 1;
        while(!q.isEmpty()) {

            int levelSize = q.size();
            List<Integer> list = new LinkedList<>();
            for(int i = 0; i < levelSize; ++i) {
                TreeNode curr = q.pollLast();
                if(oddEven % 2 == 0) {
                    list.add(0,curr.val);
                }else if(oddEven % 2 != 0) {
                    list.add(curr.val);
                }
                if(curr.left != null) q.addFirst(curr.left);
                if(curr.right != null) q.addFirst(curr.right);
            }
            res.add(list);
            oddEven++;
        }
        return res;
    }
}
