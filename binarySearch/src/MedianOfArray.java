import java.util.ArrayList;
import java.util.List;

public class MedianOfArray {

    public static void main(String[] args) {
        MedianOfArray medianOfArray = new MedianOfArray();

        System.out.println(medianOfArray.findMedianSortedArrays(
                List.of(1, 2, 3),
                List.of(4, 5)
        ));
        System.out.println(medianOfArray.findMedianSortedArrays(
                List.of(1, 2, 3),
                List.of(4, 5, 6)
        ));
        System.out.println(medianOfArray.findMedianSortedArrays(
                List.of(4, 5, 6),
                List.of(1, 2, 3)
        ));
        System.out.println(medianOfArray.findMedianSortedArrays(
                List.of(1, 3, 6),
                List.of(2, 4, 5)
        ));
        System.out.println(medianOfArray.findMedianSortedArrays(
                List.of(1, 3, 6, 8),
                List.of(2, 4, 5, 9)
        ));
    }

    public double findMedianSortedArrays(final List<Integer> a, final List<Integer> b) {
        int n = a.size();
        int m = b.size();

        if (n > m) {
            return findMedianSortedArrays(b, a);
        }

        int minI = 0;
        int maxI = n;

        int i = 0;
        int j = 0;

        double median = 0;

        while (minI <= maxI) {

            i = (minI + maxI) / 2;
            j = ((n + m + 1) / 2) - i;

            if (i > 0 && j < m && a.get(i - 1) > b.get(j)) {
                maxI = i - 1;
            } else if (j > 0 && i < n && a.get(i) < b.get(j - 1)) {
                minI = i + 1;
            } else {
                if (i == 0)
                    median = b.get(j - 1);
                else if (j == 0)
                    median = a.get(i - 1);
                else
                    median = Math.max(a.get(i - 1), b.get(j - 1));
                break;
            }
        }

        if ((n + m) % 2 == 1) {
            return median;
        }

        if (i == n) {
            return (median + b.get(j)) / 2;
        }
        if (j == m) {
            return (median + a.get(i)) / 2;
        }

        return (median + Math.min(a.get(i), b.get(j))) / 2;
    }

    public double findMedianSortedArraysByMergeSort(final List<Integer> a, final List<Integer> b) {
        int m = a.size();
        int n = b.size();

        int medianIndex = (m + n) / 2;

        List<Integer> c = new ArrayList<>(medianIndex + 1);

        int aIndex = 0;
        int bIndex = 0;


        for (int i = 0; i <= medianIndex; i++) {
            if (aIndex >= a.size()) {
                c.add(b.get(bIndex));
                bIndex++;
                continue;
            }
            if (bIndex >= b.size()) {
                c.add(a.get(aIndex));
                aIndex++;
                continue;
            }

            if (a.get(aIndex) < b.get(bIndex)) {
                c.add(a.get(aIndex));
                aIndex++;
            } else {
                c.add(b.get(bIndex));
                bIndex++;
            }
        }

        if ((m + n) % 2 == 1) {
            return c.get(medianIndex);
        } else {
            return ((double) c.get(medianIndex - 1) + (double) c.get(medianIndex)) / 2;
        }
    }
}
