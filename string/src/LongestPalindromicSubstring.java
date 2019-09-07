public class LongestPalindromicSubstring {
    /*
    Given a string S, find the longest palindromic substring in S.

    Substring of string S:

    S[i...j] where 0 <= i <= j < len(S)

    Palindrome string:

    A string which reads the same backwards. More formally, S is palindrome if reverse(S) = S.

    Incase of conflict, return the substring which occurs first ( with the least starting index ).

    Example :

    Input : "aaaabaaa"
    Output : "aaabaaa"
     */

    public static void main(String[] args) {
        LongestPalindromicSubstring solution = new LongestPalindromicSubstring();

        System.out.println(solution.longestPalindrome("aaacaaabaaa"));
    }

    public String longestPalindrome(String A) {
        String biggestPalindrome = A.substring(0, 1);
        for (int i = 0; i < A.length(); i++) {
            for (int j = 0; j < 2; j++) { // 0 - center is one single value, 1 - center between values
                if (i + j < A.length() && A.charAt(i) == A.charAt(i + j)) {
                    String palindrome = getPalindrome(A, i, i + j);

                    biggestPalindrome = palindrome.length() > biggestPalindrome.length() ?
                            palindrome : biggestPalindrome;
                }
            }
        }
        return biggestPalindrome;
    }

    private String getPalindrome(String A, int start, int end) {
        while (start > 0 && end < A.length() - 1 && A.charAt(start - 1) == A.charAt(end + 1)) {
            start--;
            end++;
        }
        return A.substring(start, end + 1);
    }
}
