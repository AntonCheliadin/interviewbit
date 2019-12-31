public class InsertionSortList {
    private static class ListNode {
        public int val;
        public ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }

        ListNode(int x, ListNode next) {
            val = x;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        ListNode n5 = new ListNode(0);
        ListNode n4 = new ListNode(-5, n5);
        ListNode n3 = new ListNode(3, n4);
        ListNode n2 = new ListNode(2, n3);
        ListNode n1 = new ListNode(10, n2);


        ListNode resultNode = new InsertionSortList().insertionSortList(n1);

        while (resultNode != null) {
            System.out.println(resultNode.val);
            resultNode = resultNode.next;
        }
    }

    /*
    Sort a linked list using insertion sort.
     */
    public ListNode insertionSortList(ListNode A) {
        ListNode root = A;

        ListNode prevNode = A;
        ListNode currNode = A.next;

        while (currNode != null) {
            ListNode nextCurr = currNode.next;
            if (currNode.val <= root.val) {
                root = moveToRoot(root, prevNode, currNode);

            } else {
                ListNode nodeThatMustBeBefore = findNodeThatMustBeBeforeCurr(root, currNode);

                if (nodeThatMustBeBefore == null) {
                    prevNode = currNode;
                } else {
                    moveToNode(nodeThatMustBeBefore, prevNode, currNode);
                }
            }
            currNode = nextCurr;
        }

        return root;
    }

    private ListNode moveToRoot(ListNode oldRoot, ListNode prevNewRoot, ListNode newRoot) {
        prevNewRoot.next = newRoot.next;
        newRoot.next = oldRoot;

        return newRoot;
    }

    private ListNode findNodeThatMustBeBeforeCurr(ListNode root, ListNode currNode) {
        ListNode iter = root;

        while (currNode.val > iter.next.val) {
            iter = iter.next;
        }

        if (iter.next == currNode) {
            return null;
        }

        return iter;
    }

    private void moveToNode(ListNode newPrev, ListNode oldPrev, ListNode currNode) {
        oldPrev.next = currNode.next;
        currNode.next = newPrev.next;
        newPrev.next = currNode;
    }
}
