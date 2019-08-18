import java.util.*;

public class LongestIncreasingSubsequence {
    /*
    Find the longest increasing subsequence of a given sequence / array.

    In other words, find a subsequence of array in which the subsequence’s elements are in strictly increasing order, and in which the subsequence is as long as possible.
    This subsequence is not necessarily contiguous, or unique.
    In this case, we only care about the length of the longest increasing subsequence.

    Example :

    Input : [0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15]
    Output : 6
    The sequence : [0, 2, 6, 9, 13, 15] or [0, 4, 6, 9, 11, 15] or [0, 4, 6, 9, 13, 15]
     */

    public static void main(String[] args) {
        LongestIncreasingSubsequence solution = new LongestIncreasingSubsequence();
        System.out.println("er = 6; ar = " + solution.lis(List.of(0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15)));
        System.out.println("er = 15; ar = " + solution.lis(List.of(69, 54, 19, 51, 16, 54, 64, 89, 72, 40, 31, 43, 1, 11, 82, 65, 75, 67, 25, 98, 31, 77, 55, 88, 85, 76, 35, 101, 44, 74, 29, 94, 72, 39, 20, 24, 23, 66, 16, 95, 5, 17, 54, 89, 93, 10, 7, 88, 68, 10, 11, 22, 25, 50, 18, 59, 79, 87, 7, 49, 26, 96, 27, 19, 67, 35, 50, 10, 6, 48, 38, 28, 66, 94, 60, 27, 76, 4, 43, 66, 14, 8, 78, 72, 21, 56, 34, 90, 89)));
    }

    public int lis(final List<Integer> A) {
        if (A.isEmpty()) {
            return 0;
        }

        int[] dp = new int[A.size()];
        dp[0] = 1;

        int maxLength = 1;

        for (int i = 1; i < A.size(); i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (A.get(i) > A.get(j)) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    maxLength = Math.max(maxLength, dp[i]);
                }
            }
        }

        return maxLength;
    }
}
