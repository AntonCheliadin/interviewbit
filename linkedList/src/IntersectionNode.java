public class IntersectionNode {

    private static class ListNode {
        public int val;
        public ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public static ListNode getIntersectionNode(ListNode a, ListNode b) {
        int aLength = getLength(a);
        int bLength = getLength(b);

        ListNode aNext = a;
        ListNode bNext = b;

        if (aLength > bLength) {
            for (int i = 0; i < aLength - bLength; i++) {
                aNext = aNext.next;
            }
        } else if (bLength > aLength) {
            for (int i = 0; i < bLength - aLength; i++) {
                bNext = bNext.next;
            }
        }

        while (aNext != null && bNext != null) {
            if (aNext == bNext) {
                return aNext;
            }
            aNext = aNext.next;
            bNext = bNext.next;
        }
        return null;
    }

    private static int getLength(ListNode a) {
        int length = 0;
        ListNode tmp = a;
        while (tmp != null) {
            length++;
            tmp = tmp.next;
        }
        return length;
    }
}
