public class LengthOfLastWord {
    /*
    Given a string s consists of upper/lower-case alphabets and empty space characters ' ',
    return the length of last word in the string.

    If the last word does not exist, return 0.

    Note: A word is defined as a character sequence consists of non-space characters only.
     */

    public int lengthOfLastWord(final String A) {
        int count = 0;

        for (int i = A.length() - 1; i >= 0; i--) {
            if (count == 0 && ' ' == A.charAt(i)) {
                continue;
            } else if (' ' == A.charAt(i)) {
                return count;
            } else {
                count++;
            }
        }

        return count;
    }
}
