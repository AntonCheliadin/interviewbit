import java.util.ArrayList;

public class ConcentricRectangular {


    public static void main(String[] args) {
        ConcentricRectangular concentricRectangular = new ConcentricRectangular();

        ArrayUtil.printMatrix(concentricRectangular.prettyPrint(5));
    }

    public ArrayList<ArrayList<Integer>> prettyPrint(int A) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();

        int matrixSize = A * 2 - 1;
        int borderIndex = matrixSize - 1;

        for (int i = 0; i < matrixSize; i++) {
            ArrayList<Integer> nestedList = new ArrayList<>();
            for (int j = 0; j < matrixSize; j++) {
                for (int k = 0; k < matrixSize; k++) {
                    if (i == k || i == borderIndex - k || j == k || j == borderIndex - k) {
                        nestedList.add(A - k);
                        break;
                    }
                }
            }

            res.add(nestedList);
        }

        return res;
    }
}
