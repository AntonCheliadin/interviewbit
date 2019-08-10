import java.util.Stack;

public class KthSmallestElementInTree {
    /*
    Given a binary search tree, write a function to find the kth smallest element in the tree.
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
        TreeNode root = new TreeNode(11);

        TreeNode depth1Left = new TreeNode(2);
        TreeNode depth1Right = new TreeNode(13);

        root.left = depth1Left;
        root.right = depth1Right;

        depth1Left.left = new TreeNode(1);
        depth1Left.right = new TreeNode(9);

        depth1Right.right = new TreeNode(57);

        depth1Right.right.left = new TreeNode(25);
        depth1Right.right.left.left = new TreeNode(17);
        depth1Right.right.right = new TreeNode(90);


        KthSmallestElementInTree solution = new KthSmallestElementInTree();
        System.out.println(solution.kthsmallest(root, 8));
        System.out.println(solution.kthsmallestRecursive(root, 8));
    }

    int minCounter = 0;
    int result;

    public int kthsmallestRecursive(TreeNode A, int B) {
        inorderRecursive(A, B);
        return result;
    }

    private void inorderRecursive(TreeNode A, int B) {
        if (A == null) {
            return;
        }

        inorderRecursive(A.left, B);
        minCounter++;

        if (minCounter == B) {
            result = A.val;
            return;
        }

        inorderRecursive(A.right, B);
    }

    public int kthsmallest(TreeNode A, int B) {
        Stack<TreeNode> stack = new Stack<>();
        int minCounter = 0;
        TreeNode curr = A;

        while (!stack.isEmpty() || curr != null) {
            addLeftBranchToStack(stack, curr);

            curr = stack.pop();

            if (++minCounter == B) {
                return curr.val;
            }

            curr = curr.right;
        }

        return -1;
    }

    private void addLeftBranchToStack(Stack<TreeNode> stack, TreeNode node) {
        TreeNode iter = node;

        while (iter != null) {
            stack.push(iter);
            iter = iter.left;
        }
    }
}
