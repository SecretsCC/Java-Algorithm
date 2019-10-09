package facebook;

public class DiameterOfBinaryTree {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }
    int ans;
    public int diameterOfBinaryTree(TreeNode root) {
        ans = 1;
        height(root);
        return ans - 1;
    }

    private int height(TreeNode node) {
        if(node == null) return 0;

        int left = height(node.left);
        int right = height(node.right);

        ans = Math.max(ans,left + right + 1);
        return Math.max(left,right) + 1;
    }
}
