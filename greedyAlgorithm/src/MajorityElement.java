import java.util.List;
import java.util.stream.Collectors;

public class MajorityElement {
    /*
    Given an array of size n, find the majority element. The majority element is the element that appears more than floor(n/2) times.

    You may assume that the array is non-empty and the majority element always exist in the array.

    Example :
    Input : [2, 1, 2]
    Return : 2 which occurs 2 times which is greater than 3/2.
     */

    public int majorityElementBySorting(final List<Integer> A) {
        List<Integer> sorted = A.stream().sorted().collect(Collectors.toList());

        return sorted.get(sorted.size() / 2);
    }

    public int majorityElement(final List<Integer> A) {
        int num = A.get(0);
        int count = 1;

        for (int i = 1; i < A.size(); i++) {
            if (A.get(i) == num) {
                count++;
            } else {
                count--;
            }
            if (count == 0) {
                num = A.get(i);
                count = 1;
            }
        }

        return num;
    }
}
