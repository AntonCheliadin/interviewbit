public class Substring {

    public static void main(String[] args) {
        Substring substring = new Substring();

        System.out.println(48 == substring.strStr("bbaabbbbbaabbaabbbbbbabbbabaabbbabbabbbbababbbabbabaaababbbaabaaaba",
                "babaaa"));
    }

    public int strStr(final String A, final String B) {
        if (A.isEmpty() || B.isEmpty()) {
            return -1;
        }
        if (B.length() > A.length()) {
            return -1;
        }

        int bLength = B.length();
        int matchLength = 0;

        for (int i = 0; i < A.length(); i++) {
            if (A.charAt(i) == B.charAt(matchLength)) {
                matchLength++;

                if (bLength == matchLength) {
                    return i - matchLength + 1;
                }
            } else {
                if (matchLength > 0) {
                    i = i - matchLength;
                }
                matchLength = 0;
            }
        }

        return -1;
    }
}
