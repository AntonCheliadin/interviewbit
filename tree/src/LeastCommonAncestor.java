import java.util.*;

public class LeastCommonAncestor {
    /*
    Find the lowest common ancestor in an unordered binary tree given two values in the tree.

     Lowest common ancestor : the lowest common ancestor (LCA) of two nodes v and w in a tree or directed acyclic graph (DAG) is the lowest (i.e. deepest) node that has both v and w as descendants.
    Example :


            _______3______
           /              \
        ___5__          ___1__
       /      \        /      \
       6      _2_     0        8
             /   \
             7    4
    For the above tree, the LCA of nodes 5 and 1 is 3.

     LCA = Lowest common ancestor
    Please note that LCA for nodes 5 and 4 is 5.

    You are given 2 values. Find the lowest common ancestor of the two nodes represented by val1 and val2
    No guarantee that val1 and val2 exist in the tree. If one value doesn’t exist in the tree then return -1.
    There are no duplicate values.
    You can use extra memory, helper functions, and can modify the node struct but, you can’t add a parent pointer.
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
        LeastCommonAncestor solution = new LeastCommonAncestor();

        TreeNode treeNode = buildTree(new ArrayList<>(List.of(79, 17, 5, 38, 24, 13, 28, 2, 14, 33, 27, -1, 4, 22, 35, -1, 3, -1, -1, 37, -1, -1, 18, 34, 32, 23, -1, -1, -1, -1, -1, 6, -1, 11, 8, -1, 21, 7, -1, -1, 16, -1, 15, -1, -1, -1, 20, 19, -1, -1, -1, -1, 29, -1, -1, 25, 1, 30, -1, 36, 12, 26, -1, 31, -1, 10, -1, -1, -1, -1, -1, 39, -1, -1, -1, -1, -1, 9, -1, -1)));

        int answer2 = solution.lca(treeNode, 16, 4);
        System.out.println(answer2);
    }

    private HashMap<Integer, Integer> valueToIndexMap = new HashMap<>();
    private Queue<TreeNode> queue = new LinkedList<>();

    public int lca(TreeNode A, int B, int C) {
        markNodeWithIndex(A, 1);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();

            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();

                if (node.left != null) {
                    markNodeWithIndex(node.left, node.val * 2);
                }
                if (node.right != null) {
                    markNodeWithIndex(node.right, node.val * 2 + 1);
                }
            }

            if (valueToIndexMap.containsKey(B) && valueToIndexMap.containsKey(C)) {
                int commonIndex = findCommonIndex(valueToIndexMap.get(B), valueToIndexMap.get(C));
                return valueToIndexMap.entrySet().stream().filter(entry -> entry.getValue().equals(commonIndex))
                        .findFirst().get().getKey();
            }
        }

        return -1;
    }

    private void markNodeWithIndex(TreeNode node, int nodeIndex) {
        valueToIndexMap.put(node.val, nodeIndex);
        node.val = nodeIndex;
        queue.add(node);
    }

    private int findCommonIndex(int i, int j) {
        while (i != j) {
            int min = Math.min(i, j);
            int max = Math.max(i, j);

            i = min;
            if (max % 2 == 1) {
                max--;
            }
            j = max / 2;
        }
        return i;
    }

    static TreeNode buildTree(List<Integer> list) {
        TreeNode[] nodes = new TreeNode[list.size() + 1];

        list.add(0, 0);
        TreeNode root = new TreeNode(list.get(1));
        nodes[1] = root;

        for (int i = 1; i < list.size(); i++) {
            TreeNode node = nodes[i];

            if (node != null) {
                if (i * 2 < list.size() && list.get(i * 2) != -1) {
                    node.left = new TreeNode(list.get(i * 2));
                    nodes[i * 2] = node.left;
                }

                if (i * 2 + 1 < list.size() && list.get(i * 2 + 1) != -1) {
                    node.right = new TreeNode(list.get(i * 2 + 1));
                    nodes[i * 2 + 1] = node.right;
                }
            }
        }

        return root;
    }

}
