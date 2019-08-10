import java.util.List;

public class RemoveDuplicatesFromSortedList {

    public static void main(String[] args) {
        ListNode A222 = new ListNode(22);
        ListNode A22 = new ListNode(2, A222);
        ListNode A2 = new ListNode(2, A22);
        ListNode A11 = new ListNode(1, A2);
        ListNode A1 = new ListNode(1, A11);
        ListNode A = new ListNode(1, A1);

        deleteDuplicates(A);
    }

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

    public static ListNode deleteDuplicates(ListNode A) {
        if (A == null) {
            return A;
        }

        ListNode currNode = A;

        while (currNode.next != null) {

            if (currNode.val == currNode.next.val) {
                currNode.next = currNode.next.next;
            } else {
                currNode = currNode.next;
            }
        }

        return A;
    }

}

