import java.util.ArrayList;
import java.util.Stack;

public class InorderTraversal {
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


        InorderTraversal solution = new InorderTraversal();
        System.out.println(solution.inorderTraversal(root));
    }

    public ArrayList<Integer> inorderTraversal(TreeNode A) {
        ArrayList<Integer> sortedList = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        TreeNode iter = A;

        while (!stack.isEmpty() || iter != null) {
            addLeftSideToStack(stack, iter);

            iter = stack.pop();

            sortedList.add(iter.val);

            iter = iter.right;
        }

        return sortedList;
    }

    private void addLeftSideToStack(Stack<TreeNode> stack, TreeNode node) {
        TreeNode iterNode = node;
        while (iterNode != null) {
            stack.push(iterNode);
            iterNode = iterNode.left;
        }
    }
}
