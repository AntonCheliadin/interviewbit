import java.util.Arrays;
import java.util.List;

/*
Find longest Arithmetic Progression in an integer array A of size N, and return its length.

More formally, find longest sequence of indices, 0 < i1 < i2 < … < ik < ArraySize(0-indexed)
such that sequence A[i1], A[i2], …, A[ik] is an Arithmetic Progression.

Arithmetic Progression is a sequence in which all the differences between consecutive pairs are the same,
i.e sequence B[0], B[1], B[2], …, B[m - 1] of length m is an Arithmetic Progression
if and only if B[1] - B[0] == B[2] - B[1] == B[3] - B[2] == … == B[m - 1] - B[m - 2]

Note: The common difference can be positive, negative or 0.
 */
public class LongestArithmeticProgression {

    public static void main(String[] args) {
        List<Integer> list = List.of(3, 6, 9, 12);
//        List<Integer> list = List.of(100, 10, 8, 300, 6, 1, 4, 3, 2, 5);

//        List<Integer> list = List.of(729652, 1382614, 740882302, 688260158, 2035576, 2688538, 879350478,
//                3341500, 3994462, 4647424, 5300386, 174780165, 902753309, 67221396, 261170013, 5953348,
//                20981554, 697413800, 634979324, 6606310, 7259272, 7912234, 8565196, 365426960, 9218158,
//                9871120, 10524082, 214497117, 780770428, 33203066, 530134298, 207525479, 339378323, 108777178,
//                466377836, 135845030, 338758184, 16429964, 614474430, 366933075, 974577226, 276742682, 124388355,
//                808614382, 721196653, 221239448, 7325136, 544225976, 564151016, 573481752);

        int result = new LongestArithmeticProgression().solve(list);
        System.out.println(result);
    }

    public int solve(final List<Integer> A) {
        int size = A.size();
        if (size < 3) {
            return size;
        }

        Integer[] arr = A.toArray(new Integer[0]);
        Arrays.sort(arr);

        int[][] dp = new int[size][size];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp.length; j++) {
                dp[i][j] = 2;
            }
        }

        int max = 2;

        for (int j = 1, i = j - 1, k = j + 1; j < size - 1; j++) {

            while (i >= 0 && k <= size - 1) {
                int diff = 2 * arr[j] - arr[i] - arr[k];

                if (diff < 0) {
                    i--;
                } else if (diff > 0) {
                    k++;
                } else {
                    dp[k][j] = dp[j][i] + 1;
                    max = Math.max(max, dp[k][j]);
                    i--;
                    k++;
                }

            }

        }

        return max;
    }
}
