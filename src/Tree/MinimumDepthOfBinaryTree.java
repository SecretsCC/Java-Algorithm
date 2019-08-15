package Tree;

public class MinimumDepthOfBinaryTree {
    public int minDepth(TreeNode root) {
        if(root == null) {
            return 0;
        }
        if(root.left == null) {
            return minDepth(root.right) + 1;
        }
        if(root.right == null) {
            return minDepth(root.left) + 1;
        }

        int leftHigh = minDepth(root.left);
        int rightHigh = minDepth(root.right);

        return Math.min(leftHigh,rightHigh) + 1;

    }
}
