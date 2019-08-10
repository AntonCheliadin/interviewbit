import java.util.List;

/*
 Given an array of integers, every element appears twice except for one. Find that single one.
 */
public class SingleNumber {

    public static void main(String[] args) {
        System.out.println(singleNumber(List.of(1, 2, 2, 3, 1)));
    }

    public static int singleNumber(final List<Integer> A) {
        int bitwiseXor = A.get(0);

        for (int i = 1; i < A.size(); i++) {
            bitwiseXor = bitwiseXor ^ A.get(i);
        }

        return bitwiseXor;
    }
}
