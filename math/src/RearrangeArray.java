import java.util.ArrayList;
import java.util.List;

public class RearrangeArray {
    /*
    Rearrange a given array so that Arr[i] becomes Arr[Arr[i]] with O(1) extra space.

    Example:
    Input : [1, 0]
    Return : [0, 1]
     Lets say N = size of the array. Then, following holds true :
    All elements in the array are in the range [0, N-1]
    N * N does not overflow for a signed integer
     */

    public static void main(String[] args) {
        RearrangeArray solution = new RearrangeArray();

        ArrayList<Integer> list = new ArrayList<>(List.of(4, 0, 2, 1, 3));
        solution.arrange(list);
        System.out.println("er= [3 4 2 0 1]; ar= " + list);
    }

    public void arrange(ArrayList<Integer> A) {
        int n = A.size();

        for (int i = 0; i < n; i++) {
            A.set(i, A.get(i) + (A.get(A.get(i)) % n) * n);
        }
        for (int i = 0; i < n; i++) {
            A.set(i, A.get(i) / n);
        }
    }
    /*
    Solution:
    Now, we will do a slight trick to encode 2 numbers in one index.
    This trick assumes that N * N does not overflow.

    1) Increase every Array element Arr[i] by (Arr[Arr[i]] % n)*n.
    2) Divide every element by N.
    Given a number as

       A = B + C * N   if ( B, C < N )
       A % N = B
       A / N = C
    We use this fact to encode 2 numbers into each element of Arr.
     */
}
