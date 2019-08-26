import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class GraphLevelOrder {
    /*
    Given a binary tree, return the level order traversal of its nodes’ values. (ie, from left to right, level by level).

    Example :
    Given binary tree

        3
       / \
      9  20
        /  \
       15   7
    return its level order traversal as:

    [
      [3],
      [9,20],
      [15,7]
    ]
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

    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode A) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(A);

        while (!queue.isEmpty()) {
            int n = queue.size();

            ArrayList<Integer> list = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                TreeNode node = queue.poll();

                list.add(node.val);

                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }

            result.add(list);
        }

        return result;
    }
}
