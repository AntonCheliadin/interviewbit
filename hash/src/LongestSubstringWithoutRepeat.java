import java.util.HashSet;

public class LongestSubstringWithoutRepeat {
    /*
    Given a string, find the length of the longest substring without repeating characters.

    Example:
    The longest substring without repeating letters for "abcabcbb" is "abc", which the length is 3.

    For "bbbbb" the longest substring is "b", with the length of 1.
     */
    public static void main(String[] args) {
        LongestSubstringWithoutRepeat solution = new LongestSubstringWithoutRepeat();

        System.out.println(solution.lengthOfLongestSubstring("abcabcbb"));
        System.out.println(solution.lengthOfLongestSubstring("abcarbcbb"));
        System.out.println(solution.lengthOfLongestSubstring("bbbbb"));
    }

    public int lengthOfLongestSubstring(String A) {
        HashSet<Character> hashSet = new HashSet<>();
        int maxSubstring = 0;
        int start = 0;

        for (Character c : A.toCharArray()) {
            while (hashSet.contains(c)) {
                hashSet.remove(A.charAt(start));
                start++;
            }
            hashSet.add(c);

            maxSubstring = Math.max(maxSubstring, hashSet.size());
        }

        return maxSubstring;
    }
}
