import java.util.ArrayList;

public class MinJumpsArray {
    /*
    Given an array of non-negative integers, A, of length N, you are initially positioned at the first index of the array.

    Each element in the array represents your maximum jump length at that position.

    Return the minimum number of jumps required to reach the last index.

    If it is not possible to reach the last index, return -1.

    Input Format:

    The first and the only argument contains an integer array, A.
    Output Format:

    Return an integer, representing the answer as described in the problem statement.
    Constraints:

    1 <= N <= 1e6
    0 <= A[i] <= 50000
    Examples:

    Input 1:
        A = [2, 1, 1]

    Output 1:
        1

    Explanation 1:
        The shortest way to reach index 2 is
            Index 0 -> Index 2
        that requires only 1 jump.

    Input 2:
        A = [2,3,1,1,4]

    Output 2:
        2

    Explanation 2:
        The shortest way to reach index 4 is
            Index 0 -> Index 1 -> Index 4
        that requires 2 jumps.

        [3,1,10, 3,1,4, 5,1,1, 1,1, 4,2, 100, 1,200, ...000...000 ]

      */


    public int jump1(ArrayList<Integer> A) {
        int start = 0;
        int end = 0;
        int jumps = 0;

        while (end < A.size() - 1) {
            int biggestNextIndex = start;

            for (int i = start, j = 0; i <= end && i < A.size(); i++, j++) {

                int nextIndex = start + j + A.get(i);

                biggestNextIndex = Math.max(biggestNextIndex, nextIndex);
            }

            if (biggestNextIndex == start) {
                return -1;
            }
            start = end + 1;
            end = biggestNextIndex;
            jumps++;
        }

        return jumps;
    }

    public int jump2(ArrayList<Integer> A) {
        if (A.size() == 1) {
            return 0;
        }

        int maxIndex = A.get(0);
        int lastMaxIndex = A.get(0);
        int jumps = 1;

        for (int i = 1; i < A.size(); i++) {
            if (maxIndex < i) {
                return -1;
            }

            if (lastMaxIndex < i) {
                jumps++;
                lastMaxIndex = maxIndex;
            }

            maxIndex = Math.max(maxIndex, i + A.get(i));
        }

        return jumps;
    }
}