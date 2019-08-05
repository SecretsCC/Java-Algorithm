package Stack;

import java.util.LinkedList;
import java.util.List;

public class PreOrder {
    public static List<Integer> preOrder(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        LinkedList<TreeNode> stack = new LinkedList<>();

        stack.add(root);
        while(!stack.isEmpty()) {
            TreeNode tmp = stack.pollLast();
            res.add(tmp.val);
            if(root.right != null) {
                stack.add(root.right);
            }
            if(root.left != null) {
                stack.add(root.left);
            }
        }

        return res;


    }
}
