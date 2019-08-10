public class AddTwoNumbersAsLists {

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
        AddTwoNumbersAsLists addTwoNumbersAsLists = new AddTwoNumbersAsLists();

        ListNode A3 = new ListNode(1);
        ListNode A2 = new ListNode(9, A3);
        ListNode A1 = new ListNode(9, A2);

        ListNode B1 = new ListNode(1);

        ListNode res = addTwoNumbersAsLists.addTwoNumbers(A1, B1);

        System.out.println("er 0->0->2 (200)");
    }

    public ListNode addTwoNumbers(ListNode A, ListNode B) {
        ListNode fakeHead = new ListNode(0);
        ListNode curr = fakeHead;

        int extra = 0;

        while (A != null || B != null) {
            int aVal = A != null ? A.val : 0;
            int bVal = B != null ? B.val : 0;

            int sum = aVal + bVal + extra;

            extra = sum / 10;

            curr.next = new ListNode(sum % 10);
            curr = curr.next;

            A = A != null ? A.next : null;
            B = B != null ? B.next : null;
        }

        if (extra == 1) {
            curr.next = new ListNode(1);
        }

        return fakeHead.next;
    }
}
