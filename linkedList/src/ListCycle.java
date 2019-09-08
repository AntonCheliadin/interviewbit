public class ListCycle {
    /*
    Given a linked list, return the node where the cycle begins. If there is no cycle, return null.

    Try solving it using constant additional space.
    Example :
    Input :
                      ______
                     |     |
                     \/    |
            1 -> 2 -> 3 -> 4

    Return the node corresponding to node 3.
     */

    private static class ListNode {
        public int val;
        public ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode detectCycle(ListNode a) {
        ListNode cycle = new ListNode(0);

        while (a != null) {
            if (a.next == cycle) {
                return a;
            }
            ListNode prev = a;
            a = a.next;

            prev.next = cycle;
        }

        return null;
    }
}
