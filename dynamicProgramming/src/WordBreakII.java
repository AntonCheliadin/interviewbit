import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/*
Given a string A and a dictionary of words B,
add spaces in A to construct a sentence where each word is a valid dictionary word.

Return all such possible sentences.

Note : Make sure the strings are sorted in your result.
*/
public class WordBreakII {

    public static void main(String[] args) {
        WordBreakII solution = new WordBreakII();
        ArrayList<String> answer = solution.wordBreak(
//                "catsanddog",
//                new ArrayList<>(List.of("cat", "cats", "and", "sand", "dog"))
                "aaabaaaaab",
                new ArrayList<>(List.of("aabbbaaa", "aaba", "a", "b", "a", "babbbabb", "baaaab"))
        );

        System.out.println(answer);
    }

    public ArrayList<String> wordBreak(String A, ArrayList<String> B) {
        List<String> dictionary = B.stream().distinct().collect(Collectors.toList());

        ArrayList<String> result = new ArrayList<>();

        List<List<Integer>> dp = new ArrayList<>();

        for (int i = 0; i < dictionary.size(); i++) {
            if (A.startsWith(dictionary.get(i))) {
                ArrayList<Integer> list = new ArrayList<>();
                list.add(i);
                dp.add(list);
            }
        }

        while (!dp.isEmpty()) {
            List<Integer> list = dp.get(0);

            int offset = calculateOffset(dictionary, list);

            if (isSentanceFinished(A, offset)) {
                result.add(buildSentence(list, dictionary));
            } else {
                for (int j = 0; j < dictionary.size(); j++) {
                    if (A.startsWith(dictionary.get(j), offset)) {
                        ArrayList<Integer> list2 = new ArrayList<>(list);
                        list2.add(j);
                        dp.add(list2);
                    }
                }
            }

            dp.remove(list);
        }

        result.sort(String::compareTo);

        return result;
    }

    private String buildSentence(List<Integer> usedWords, List<String> dictionary) {
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < usedWords.size() - 1; i++) {
            stringBuilder.append(dictionary.get(usedWords.get(i))).append(' ');
        }
        stringBuilder.append(dictionary.get(usedWords.get(usedWords.size() - 1)));

        return stringBuilder.toString();
    }

    private boolean isSentanceFinished(String A, int offset) {
        return offset == A.length();
    }

    private int calculateOffset(List<String> B, List<Integer> list) {
        int offset = 0;

        for (int j = 0; j < list.size(); j++) {
            offset += B.get(list.get(j)).length();
        }
        return offset;
    }

}
