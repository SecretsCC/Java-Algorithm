package facebook;

public class ValidBinarySearchTree {
    class TreeNode {
        TreeNode left;
        TreeNode right;
        Integer val;

        public TreeNode(int x){
            this.val = x;
        }
    }
    public boolean isValidBST(TreeNode root) {

        return helper(root,null,null);
    }

    public boolean helper(TreeNode node,Integer lower,Integer upper) {
        if (node == null) return true;

        int val = node.val;
        if (lower != null && val <= lower) return false;
        if (upper != null && val >= upper) return false;

        return helper(node.right, val, upper) && helper(node.left, lower, val);
    }
}
