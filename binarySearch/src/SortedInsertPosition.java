import java.util.ArrayList;
import java.util.List;

public class SortedInsertPosition {
    /*
    Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

    You may assume no duplicates in the array.

    Here are few examples.

    [1,3,5,6], 5 → 2
    [1,3,5,6], 2 → 1
    [1,3,5,6], 7 → 4
    [1,3,5,6], 0 → 0
     */
    public static void main(String[] args) {
        SortedInsertPosition solution = new SortedInsertPosition();

        ArrayList<Integer> list = new ArrayList<>(List.of(1, 3, 5, 6));
        System.out.println("er= 2; ar = " + solution.searchInsert(list, 5));
        System.out.println("er= 1; ar = " + solution.searchInsert(list, 2));
        System.out.println("er= 4; ar = " + solution.searchInsert(list, 7));
        System.out.println("er= 0; ar = " + solution.searchInsert(list, 0));
    }

    public int searchInsert(ArrayList<Integer> a, int b) {
        int start = 0;
        int mid;
        int end = a.size() - 1;

        while (start <= end) {
            mid = (start + end) / 2;

            if (a.get(mid) == b) {
                return mid;
            }

            if (a.get(mid) > b) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return start;
    }
}
