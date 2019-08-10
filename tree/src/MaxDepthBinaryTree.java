public class MaxDepthBinaryTree {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
            left = null;
            right = null;
        }
    }

    public int maxDepth(TreeNode A) {
        if (A == null) {
            return 0;
        }

        int leftDepth = maxDepth(A.left);
        int rightDepth = maxDepth(A.right);
        return Math.max(leftDepth, rightDepth) + 1;
    }
}
