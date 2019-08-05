package Stack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        if(root == null) return res;


        q.add(root);
        while(!q.isEmpty()) {
            int levelSize = q.size();
            List<Integer> mid = new ArrayList<>();
            for(int i = 0; i < levelSize; ++i) {
                TreeNode curr = q.poll();
                mid.add(curr.val);
                if(curr.left != null) {
                    q.add(curr.left);
                }
                if(curr.right != null) {
                    q.add(curr.right);
                }
            }
            res.add(mid);
        }
        return res;
    }
}
