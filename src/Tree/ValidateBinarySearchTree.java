package Tree;

public class ValidateBinarySearchTree {
    public boolean isValidBST(TreeNode root) {
        return helper(root,null,null);
    }

    public boolean helper(TreeNode root, Integer lower, Integer higher) {
        if(root == null) return true;
        if(lower != null && root.val  <= lower) return false;
        if(higher != null && root.val >= higher ) return false;

        if(!helper(root.right,root.val,higher)) return false;
        if(!helper(root.left,lower,root.val)) return false;
        return true;

    }
}
