package facebook;

public class BinaryTreeMaximumPathSum {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }

    int res = 0;

    public int maxPathSum(TreeNode root) {
        maxSum(root);
        return res;
    }

    private int maxSum(TreeNode node ) {
        if(node == null) return 0;

        int left = Math.max(0,maxSum(node.left));
        int right = Math.max(0,maxSum(node.right));

        int station = node.val + left + right;
        res = Math.max(res,station);

        return node.val + Math.max(left,right);
    }
}
