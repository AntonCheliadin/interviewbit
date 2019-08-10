import java.util.*;

public class Subset {

    /*
    If S = [1,2,3], a solution is:
[
  [],
  [1],
  [1, 2],
  [1, 2, 3],
  [1, 3],
  [2],
  [2, 3],
  [3],
]
     */
    public static void main(String[] args) {
        Subset subset = new Subset();

        ArrayList<Integer> integers = new ArrayList<>(List.of(1, 2, 3, 4));
        ArrayList<ArrayList<Integer>> res = subset.subsets(integers);
        System.out.println("res" + res);
        ArrayUtil.printMatrix(res);
    }

    public ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> A) {
        Collections.sort(A);
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        subsetsUtil(A, result, new ArrayList<>(), 0);

        return result;
    }

    private void subsetsUtil(ArrayList<Integer> A, ArrayList<ArrayList<Integer>> res, ArrayList<Integer> subset, int index) {
        res.add((new ArrayList<>(subset)));

        for (int i = index; i < A.size(); i++) {
            subset.add(A.get(i));
            subsetsUtil(A, res, subset, i + 1);
            subset.remove(subset.size() - 1);
        }
    }
}
