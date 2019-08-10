import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class INVERSIONS {

    public static void main(String[] args) {
        INVERSIONS inversions = new INVERSIONS();

        ArrayList<Integer> list = new ArrayList<>();
////        list.addAll(List.of(2, 4, 1, 3, 5));
//        System.out.println("er=3; ar=" + inversions.countInversions(list));
        list.addAll(List.of(84, 2, 37, 3, 67, 82, 19, 97, 91, 63));
        System.out.println("er=16; ar=" + inversions.countInversions(list));
    }

    // val = 1 2 3 4 5
    // i n = 0 1 2 3 4
    // i o = 2 0 3 1 4


    public int countInversions(ArrayList<Integer> A) {

        ArrayList<Integer> list = new ArrayList<>(A);
        Collections.sort(list);

        HashMap<Integer, Integer> indexByVal = new HashMap<Integer, Integer>();

        for (int i = 0; i < list.size(); i++) {
            indexByVal.put(list.get(i), i);
        }

        int count = 0;


        return count / 2;
    }


    public int countInversionsRecursive(ArrayList<Integer> A, int start, int end) {

        if (end <= start) {
            return 0;
        }

        int k = (start + end) / 2;

        int count1 = countInversionsRecursive(A, start, k);
        int count2 = countInversionsRecursive(A, k + 1, end);

//        merge(A, start,k+1, end);

        return count1 + count2;

    }
}
