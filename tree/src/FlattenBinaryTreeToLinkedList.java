/*
Given a binary tree, flatten it to a linked list in-place.
Note that the left child of all nodes should be NULL.
 */
public class FlattenBinaryTreeToLinkedList {
    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode flatten(TreeNode a) {
        TreeNode node = a;

        while (node != null) {
            if (node.left != null) {

                TreeNode theMostRightNode = findTheMostRightNode(node.left);

                theMostRightNode.right = node.right;

                node.right = node.left;

                node.left = null;
            }

            node = node.right;
        }

        return a;
    }

    private TreeNode findTheMostRightNode(TreeNode node) {
        while (node.right != null) {
            node = node.right;
        }
        return node;
    }
}
