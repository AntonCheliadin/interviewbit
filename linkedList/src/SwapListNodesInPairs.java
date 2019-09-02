public class SwapListNodesInPairs {
    /*
    Given a linked list, swap every two adjacent nodes and return its head.

    For example,
    Given 1->2->3->4, you should return the list as 2->1->4->3.

    Your algorithm should use only constant space. You may not modify the values in the list, only nodes itself can be changed.
     */
    static class ListNode {
        public int val;
        public ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);

        ListNode node2 = new ListNode(2);
        node1.next = node2;

        ListNode node3 = new ListNode(3);
        node2.next = node3;

        ListNode node4 = new ListNode(4);
        node3.next = node4;

        ListNode node5 = new ListNode(5);
        node4.next = node5;

        SwapListNodesInPairs solution = new SwapListNodesInPairs();
        ListNode node = solution.swapPairs(node1);
        while (node != null) {
            System.out.print(" - " + node.val);
            node = node.next;
        }
    }

    public ListNode swapPairs(ListNode A) {
        if (A == null) {
            return null;
        }
        if (A.next == null) {
            return A;
        }
        ListNode head = A.next;
        ListNode currNode = A;
        ListNode prevNode = null;

        while (currNode != null && currNode.next != null) {
            ListNode nextNode = currNode.next;

            if (prevNode != null) {
                prevNode.next = nextNode;
            }
            ListNode futureCurrentNode = nextNode.next;

            nextNode.next = currNode;

            prevNode = currNode;
            currNode = futureCurrentNode;
        }

        prevNode.next = currNode;

        return head;
    }
}
