import java.util.Collections;
import java.util.List;

public class LongestConsecutiveSequence {

    public int longestConsecutive(final List<Integer> A) {
        Collections.sort(A);

        int maxLength = 1;
        int currLength = 1;

        for (int i = 1; i < A.size(); i++) {
            if (A.get(i) - 1 == A.get(i - 1)) {
                currLength++;
            } else if (A.get(i) != A.get(i - 1)) {
                maxLength = Math.max(maxLength, currLength);
                currLength = 1;
            }
        }
        maxLength = Math.max(maxLength, currLength);

        return maxLength;
    }
}
