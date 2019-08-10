import java.util.ArrayList;
import java.util.List;

/*
 Given an array of N integers, find the pair of integers in the array which have minimum XOR value.
 Report the minimum XOR value.
 */
public class MinXor {

    public static void main(String[] args) {
        System.out.println(findMinXor(new ArrayList<>(List.of(0, 4, 7, 9))));
    }

    public static int findMinXor(ArrayList<Integer> A) {
        A.sort(Integer::compareTo);

        int min = A.get(0) ^ A.get(1);

        for (int i = 2; i < A.size(); i++) {
            int xor = A.get(i) ^ A.get(i - 1);
            min = Math.min(xor, min);
        }

        return min;
    }
}
