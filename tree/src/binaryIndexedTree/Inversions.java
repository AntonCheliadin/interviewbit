package binaryIndexedTree;

import java.util.ArrayList;
import java.util.List;

public class Inversions {

    public static void main(String[] args) {
        Inversions inversions = new Inversions();

        ArrayList<Integer> list = new ArrayList<>();
        list.addAll(List.of(2, 4, 1, 3, 5));
        System.out.println("er=3; ar=" + inversions.countInversions(list));
        list.clear();
        list.addAll(List.of(84, 2, 37, 3, 67, 82, 19, 97, 91, 63));
        System.out.println("er=16; ar=" + inversions.countInversions(list));
    }


    public int countInversions(ArrayList<Integer> A) {
        int max = A.stream().max(Integer::compareTo).get();

        BinaryIndexedTree bit = new BinaryIndexedTree(max);

        int inversions = 0;
        for (int i = A.size() - 1; i >= 0; i--) {
            inversions += bit.getSum(A.get(i) - 1);

            bit.update(A.get(i), 1);
        }

        return inversions;
    }
}
