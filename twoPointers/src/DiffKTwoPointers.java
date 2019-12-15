import java.util.List;

public class DiffKTwoPointers {
    /*
    Given an array ‘A’ of sorted integers and another non negative integer k,
    find if there exists 2 indices i and j such that A[i] - A[j] = k, i != j.
     */

    public static void main(String[] args) {
        DiffKTwoPointers diffKTwoPointers = new DiffKTwoPointers();

        System.out.println(diffKTwoPointers.diffPossible(List.of(1, 3, 5), 0));
        System.out.println(diffKTwoPointers.diffPossible(List.of(
                0, 1, 9, 10, 13, 17, 17, 17, 23, 25, 29, 30, 37, 38, 39, 39, 40, 41, 42, 60, 64, 70, 70, 70, 72, 75, 85, 85, 90, 91, 91, 93, 95
        ), 83));
    }

    public int diffPossible(List<Integer> A, int B) {
        int i = 0;
        int j = 1;

        while (i < A.size() && j < A.size()) {
            int diff = A.get(j) - A.get(i);

            if (diff == B && i != j) {
                return 1;
            }

            if (diff < B) {
                j++;
            } else {
                i++;
            }
        }

        return 0;
    }
}
