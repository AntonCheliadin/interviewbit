import java.awt.event.AWTEventListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BinarySearchKthSmallestElement {

    public static void main(String[] args) {
        System.out.println("1==" + kthsmallest(List.of(1, 2, 5, 6, 0, 4, 5, 3), 2));
        System.out.println("5==" + kthsmallest(List.of(1, 2, 5, 6, 0, 4, 5, 3), 6));

        System.out.println("17==" + kthsmallest(List.of(
                8, 16, 80, 55, 32, 8, 38, 40, 65, 18, 15, 45, 50, 38, 54, 52, 23, 74, 81, 42, 28, 16, 66,
                35, 91, 36, 44, 9, 85, 58, 59, 49, 75, 20, 87, 60, 17, 11, 39, 62, 20, 17, 46, 26, 81, 92), 9));

    }

    public static int kthsmallest(final List<Integer> A, int B) {
        int min = Collections.min(A);
        int max = Collections.max(A);

        while (min <= max) {
            int med = min + ((max - min) / 2);
            int counterLess = 0;
            int counterEquals = 0;

            for (int i = 0; i < A.size(); i++) {
                if (A.get(i) < med) {
                    counterLess++;
                } else if (A.get(i) == med) {
                    counterEquals++;
                }

                if (counterLess >= B) {
                    break;
                }
            }

            if (counterLess < B && counterEquals + counterLess >= B) {
                return med;
            }

            if (counterLess >= B) {
                max = med - 1;
            } else {
                min = med + 1;
            }

        }

        return 0;
    }
}
