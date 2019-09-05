public class BalancedBinaryTree {
    /*
    Given a binary tree, determine if it is height-balanced.

     Height-balanced binary tree : is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
    Return 0 / 1 ( 0 for false, 1 for true ) for this problem

    Example:
     Input: 17 1 2 3 4 5 -1 6 7 8 -1 -1 -1 -1 -1 -1 -1 -1

               1
            2       3
        4     5   -    6
      7  8   -  -     -  -
    - - - -
    Output: 1
     */
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
            left = null;
            right = null;
        }
    }

    public static void main(String[] args) {
        BalancedBinaryTree solution = new BalancedBinaryTree();

        TreeNode root = new TreeNode(0);
        System.out.println(solution.isBalanced(root));

        TreeNode c1 = new TreeNode(1);
        TreeNode c2 = new TreeNode(2);
        root.left = c1;
        root.right = c2;
        System.out.println(solution.isBalanced(root));

        TreeNode c3 = new TreeNode(3);
        c1.left = c3;
        System.out.println(solution.isBalanced(root));

        TreeNode c4 = new TreeNode(4);
        c3.left = c4;
        System.out.println(solution.isBalanced(root));
    }

    public int isBalanced(TreeNode A) {
        int level = getLevel(A);

        return level == -1 ? 0 : 1;
    }

    private int getLevel(TreeNode A) {
        if (A == null) {
            return 0;
        }

        int levelL = getLevel(A.left);
        int levelR = getLevel(A.right);

        if (Math.abs(levelL - levelR) > 1 || levelL == -1 || levelR == -1) {
            return -1;
        }

        return Math.max(levelL, levelR) + 1;
    }
}
