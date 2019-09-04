import java.util.ArrayList;
import java.util.Date;

public class SpiralOrderMatrixII {
    /*
    Given an integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.

    Example:
    Given n = 3,

    You should return the following matrix:
    [
      [ 1, 2, 3 ],
      [ 8, 9, 4 ],
      [ 7, 6, 5 ]
    ]
     */
    public static void main(String[] args) {
        SpiralOrderMatrixII solution = new SpiralOrderMatrixII();

        long start = new Date().getTime();
        ArrayList<ArrayList<Integer>> answer = solution.generateMatrix(9000);
//        System.out.println(answer);
        long duration1 = new Date().getTime() - start;
        System.out.println("duration1=" + duration1);
    }

    public ArrayList<ArrayList<Integer>> generateMatrix(int A) {
        int[][] matrix = new int[A][A];

        int counter = 1;

        int steps = A;
        int sign = 1;

        int i = 0;
        int j = -1;

        while (steps > 0) {
            for (int s = 0; s < steps; s++) {
                j += sign;
                matrix[i][j] = counter++;
            }
            steps--;

            for (int s = 0; s < steps; s++) {
                i += sign;
                matrix[i][j] = counter++;
            }

            sign *= -1;
        }

        return matrixArrayToList(matrix);
    }

    private ArrayList<ArrayList<Integer>> matrixArrayToList(int[][] matrix) {
        int n = matrix.length;
        ArrayList<ArrayList<Integer>> matrixList = new ArrayList<>(n);

        for (int i = 0; i < n; i++) {
            ArrayList<Integer> columns = new ArrayList<>(n);
            for (int j = 0; j < n; j++) {
                columns.add(matrix[i][j]);
            }
            matrixList.add(columns);
        }

        return matrixList;
    }
}
