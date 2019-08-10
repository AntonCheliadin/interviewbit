import java.util.*;
import java.util.List;

public class MergeKSortedLists {

    class ListNode {
        public int val;
        public ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public static void main(String[] args) {
        MergeKSortedLists mergeKSortedLists = new MergeKSortedLists();

        ListNode list1 = mergeKSortedLists.collectionToLinkedList(List.of(1, 10, 20));
        ListNode list2 = mergeKSortedLists.collectionToLinkedList(List.of(4, 11, 13));
        ListNode list3 = mergeKSortedLists.collectionToLinkedList(List.of(3, 8, 9, 11));

        ListNode result = mergeKSortedLists.mergeKLists(new ArrayList<>(List.of(list1, list2, list3)));

        System.out.println("result first node " + result.val);

    }

    public ListNode mergeKLists(ArrayList<ListNode> a) {
        PriorityQueue<ListNode> queue = new PriorityQueue<>(Comparator.comparingInt(x -> x.val));

        for (ListNode listNode : a) {
            ListNode iter = listNode;
            while (iter != null) {
                queue.add(new ListNode(iter.val));
                iter = iter.next;
            }
        }

        ListNode fakeHead = new ListNode(0);
        ListNode curr = fakeHead;

        while (!queue.isEmpty()) {
            ListNode next = queue.poll();
            curr.next = next;
            curr = next;
        }

        return fakeHead.next;
    }

    private ListNode collectionToLinkedList(Collection<Integer> collection) {
        ListNode fakeStart = new ListNode(0);
        ListNode curr = fakeStart;

        for (Integer num : collection) {
            ListNode node = new ListNode(num);
            curr.next = node;
            curr = node;
        }

        return fakeStart.next;
    }
}
