import java.util.ArrayList;
import java.util.List;

public class SpiralOrderMatrix {

    public static void main(String[] args) {
        List<List<Integer>> matrix31 = List.of(
                List.of(1),
                List.of(2),
                List.of(3)
        );
        List<List<Integer>> matrix13 = List.of(
                List.of(1, 2, 3)
        );
        List<List<Integer>> matrix22 = List.of(
                List.of(1, 2),
                List.of(3, 4),
                List.of(5, 6)
        );
        List<List<Integer>> matrix23 = List.of(
                List.of(1, 2, 3),
                List.of(4, 5, 6)
        );
        List<List<Integer>> matrix3 = List.of(
                List.of(1, 2, 3),
                List.of(4, 5, 6),
                List.of(7, 8, 9)
        );
        List<List<Integer>> matrix4 = List.of(
                List.of(1, 2, 3, 4),
                List.of(5, 6, 7, 8),
                List.of(9, 10, 11, 12),
                List.of(13, 14, 15, 16)
        );

        List<List<Integer>> matrix5 = List.of(
                List.of(1, 2, 3, 4, 5),
                List.of(6, 7, 8, 9, 10),
                List.of(11, 12, 13, 14, 15),
                List.of(16, 17, 18, 19, 20),
                List.of(21, 22, 23, 24, 25)
        );
        List<List<Integer>> matrix6 = List.of(
                List.of(1, 2, 3, 4, 5, 6),
                List.of(7, 8, 9, 10, 11, 12),
                List.of(13, 14, 15, 16, 17, 18),
                List.of(19, 20, 21, 22, 23, 24),
                List.of(25, 25, 27, 28, 29, 30),
                List.of(31, 32, 33, 34, 35, 36)
        );

        SpiralOrderMatrix spiralOrderMatrix = new SpiralOrderMatrix();

        System.out.println(spiralOrderMatrix.spiralOrder(matrix31));
        System.out.println(spiralOrderMatrix.spiralOrder(matrix13));
        System.out.println(spiralOrderMatrix.spiralOrder(matrix22));
        System.out.println(spiralOrderMatrix.spiralOrder(matrix23));
        System.out.println(spiralOrderMatrix.spiralOrder(matrix3));
        System.out.println(spiralOrderMatrix.spiralOrder(matrix4));
        System.out.println(spiralOrderMatrix.spiralOrder(matrix5));
        System.out.println(spiralOrderMatrix.spiralOrder(matrix6));
    }


    public ArrayList<Integer> spiralOrder(final List<List<Integer>> A) {
        ArrayList<Integer> spiral = new ArrayList<>();

        int m = A.size();
        int n = A.get(0).size();

        int add = 1;
        int min = 0;
        int maxRow = A.size();
        int maxColumn = A.get(0).size();

        int i = min;
        int j = min;

        for (; j < maxColumn; j += add) {
            spiral.add(A.get(i).get(j));
        }


        while (m * n > spiral.size()) {
            if (add > 0) {
                maxColumn--;
            } else {
                maxRow--;
                min++;
            }

            for (i += add, j += -1 * add; i >= min && i < maxRow; i += add) {
                spiral.add(A.get(i).get(j));
            }
            add = add * (-1);
            for (i += add, j += add; j >= min && j < maxColumn; j += add) {
                spiral.add(A.get(i).get(j));
            }
        }
        return spiral;

    }
}
