import java.util.List;

public class MaxProductSubarray {
    /*
    Find the contiguous subarray within an array (containing at least one number) which has the largest product.
    Return an integer corresponding to the maximum product possible.

    Example :

    Input : [2, 3, -2, 4]
    Return : 6

    Possible with [2, 3]
     */
    public int maxProduct(final List<Integer> A) {
        int max = 0;

        int pos = 1;
        int neg = 1;

        for (Integer num : A) {
            if (num == 0) {
                pos = 1;
                neg = 1;
            } else if (num > 0) {
                pos *= num;
                neg *= num;
                max = Math.max(max, pos);
            } else {
                int prevPos = pos;

                if (neg * num > pos) {
                    pos = neg * num;
                    max = Math.max(max, pos);
                } else {
                    pos = 1;
                }

                neg = prevPos * num;
            }
        }

        return max;
    }
}
