import java.util.ArrayList;
import java.util.List;

public class MinSumPathInMatrix {
    /*
    Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right
    which minimizes the sum of all numbers along its path.

     Note: You can only move either down or right at any point in time.
     */
    public static void main(String[] args) {
        MinSumPathInMatrix solution = new MinSumPathInMatrix();

        ArrayList<ArrayList<Integer>> a = new ArrayList<>();
        a.add(new ArrayList<>(List.of(1, 3, 2)));
        a.add(new ArrayList<>(List.of(4, 3, 1)));
        a.add(new ArrayList<>(List.of(5, 6, 1)));

        System.out.println("er=8; ar=" + solution.minPathSum(a));
    }

    public int minPathSum(ArrayList<ArrayList<Integer>> A) {
        int m = A.size();
        int n = A.get(m - 1).size();

        int[][] sumMatrix = new int[m][n];

        sumMatrix[0][0] = A.get(0).get(0);
        for (int i = 1; i < m; i++) {
            sumMatrix[i][0] = sumMatrix[i - 1][0] + A.get(i).get(0);
        }
        for (int j = 1; j < n; j++) {
            sumMatrix[0][j] = sumMatrix[0][j - 1] + A.get(0).get(j);
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                int leftSum = sumMatrix[i][j - 1];
                int topSum = sumMatrix[i - 1][j];

                sumMatrix[i][j] = A.get(i).get(j) + Math.min(leftSum, topSum);
            }
        }

        return sumMatrix[m - 1][n - 1];
    }
}
