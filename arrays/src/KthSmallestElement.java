import java.util.ArrayList;
import java.util.List;

public class KthSmallestElement {

    public static void main(String[] args) {
//        System.out.println("1==" + kthsmallest(List.of(1, 2, 5, 6, 0, 4, 5, 3), 2));
//        System.out.println("5==" + kthsmallest(List.of(1, 2, 5, 6, 0, 4, 5, 3), 6));
//        System.out.println("17==" + kthsmallest(List.of(8, 8, 9, 11, 15, 16, 16, 17, 17, 18, 20), 9));

        ArrayList<Integer> list = new ArrayList<>();

        list.addAll(List.of(
                8, 16, 80, 55, 32, 8, 38, 40, 65, 18, 15, 45, 50, 38, 54, 52, 23, 74, 81, 42, 28, 16, 66,
                35, 91, 36, 44, 9, 85, 58, 59, 49, 75, 20, 87, 60, 17, 11, 39, 62, 20, 17, 46, 26, 81, 92));
        System.out.println("17==" + kthsmallest(list, 9));

    }

    public static int kthsmallest(final List<Integer> A, int B) {
        if (B < A.size() / 2) {
            return kthTheMost(A, B, true);
        } else {
            return kthTheMost(A, A.size() - B + 1, false);
        }
    }

    private static int kthTheMost(final List<Integer> A, int k, boolean asc) {
        int count = 0;

        int prevKth = -1;
        int kth;

        do {
            int minOrMax = asc ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            int repeated = 1;
            for (int j = 0; j < A.size(); j++) {

                if ((asc && (prevKth == -1 || prevKth < A.get(j)) && A.get(j) < minOrMax) ||
                        (!asc && (prevKth == -1 || prevKth > A.get(j)) && A.get(j) > minOrMax)) {

                    minOrMax = A.get(j);
                    repeated = 1;
                } else if (A.get(j) == minOrMax) {
                    repeated++;
                }
            }

            kth = minOrMax;
            prevKth = kth;
            count += repeated;

        } while (count < k);

        return kth;
    }
}
