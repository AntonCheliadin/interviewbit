import java.util.ArrayList;

public class RotateMatrix {
    /*
    You are given an n x n 2D matrix representing an image.

    Rotate the image by 90 degrees (clockwise).

    You need to do this in place.

     1  2  3  4     13  9   5  1   [13,  9, 5, 1]
     5  6  7  8     14  *   *  2   [14, 10, 6, 2]
     9 10 11 12     15  *   *  3   [15, 11, 7, 3]
    13 14 15 16     16  12  8  4   [16, 12, 8, 4]
     */

    public static void main(String[] args) {
        RotateMatrix solution = new RotateMatrix();
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();

        ArrayList<Integer> columns1 = new ArrayList<>();
        columns1.add(1);
        columns1.add(2);
        columns1.add(3);
        columns1.add(4);
        list.add(columns1);

        ArrayList<Integer> columns2 = new ArrayList<>();
        columns2.add(5);
        columns2.add(6);
        columns2.add(7);
        columns2.add(8);
        list.add(columns2);

        ArrayList<Integer> columns3 = new ArrayList<>();
        columns3.add(9);
        columns3.add(10);
        columns3.add(11);
        columns3.add(12);
        list.add(columns3);

        ArrayList<Integer> columns4 = new ArrayList<>();
        columns4.add(13);
        columns4.add(14);
        columns4.add(15);
        columns4.add(16);
        list.add(columns4);

        solution.rotate(list);
        System.out.println(list);
    }

    public void rotate(ArrayList<ArrayList<Integer>> a) {
        int n = a.size() - 1;

        for (int i = 0; i < a.size() / 2; i++) {
            for (int j = i; j < n - i; ++j) {

                int temp1 = a.get(n - j).get(i);
                int temp2 = a.get(n - i).get(n - j);
                int temp3 = a.get(j).get(n - i);
                int temp4 = a.get(i).get(j);

                // swap
                a.get(i).set(j, temp1);
                a.get(n - j).set(i, temp2);
                a.get(n - i).set(n - j, temp3);
                a.get(j).set(n - i, temp4);
            }
        }
    }
}
