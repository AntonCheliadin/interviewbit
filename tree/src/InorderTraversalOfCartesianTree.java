import java.util.ArrayList;
import java.util.List;

public class InorderTraversalOfCartesianTree {
    /*
    Given an inorder traversal of a cartesian tree, construct the tree.
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
        InorderTraversalOfCartesianTree solution = new InorderTraversalOfCartesianTree();

        TreeNode root = solution.buildTree(new ArrayList<>(List.of(9, 3, 7, 1, 8, 12, 10, 5)));
        System.out.println(root.val);
    }

    public TreeNode buildTree(ArrayList<Integer> A) {
        return buildTree(A, 0, A.size() - 1);
    }

    private TreeNode buildTree(ArrayList<Integer> A, int start, int end) {
        if (end < start) {
            return null;
        }

        int maxI = findMaxI(A, start, end);

        TreeNode parent = new TreeNode(A.get(maxI));
        parent.left = buildTree(A, start, maxI - 1);
        parent.right = buildTree(A, maxI + 1, end);

        return parent;
    }

    private int findMaxI(ArrayList<Integer> A, int start, int end) {
        int maxI = start;
        for (int i = start + 1; i <= end; i++) {
            if (A.get(i) > A.get(maxI)) {
                maxI = i;
            }
        }
        return maxI;
    }
}
