import java.util.ArrayList;
import java.util.Comparator;

public class WordLadder {
    /*
    Given two words (start and end), and a dictionary, find the length of shortest transformation sequence from start to end, such that:

    You must change exactly one character in every transformation
    Each intermediate word must exist in the dictionary
    Example :

    Given:
    start = "hit"
    end = "cog"
    dict = ["hot","dot","dog","lot","log"]
    As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
    return its length 5.

    Note that we account for the length of the transformation path instead of the number of transformation itself.

     Note:
    Return 0 if there is no such transformation sequence.
    All words have the same length.
    All words contain only lowercase alphabetic characters.
     */

    public static void main(String[] args) {
        WordLadder solution = new WordLadder();

        ArrayList<String> dictionary = new ArrayList<>();
        dictionary.add("hot");
        dictionary.add("dot");
        dictionary.add("dog");
        dictionary.add("lot");
        dictionary.add("log");
        System.out.println("er=5; ar=" + solution.ladderLength("hit", "cog", dictionary));
    }

    public int ladderLength(String start, String end, ArrayList<String> dictV) {
        dictV.add(start);
        dictV.add(end);
        ArrayList<ArrayList<String>> edges = buildEdges(dictV);

        ArrayList<ArrayList<String>> paths = new ArrayList<>();

        ArrayList<String> firstPath = new ArrayList<>();
        firstPath.add(start);
        paths.add(firstPath);

        return walk(end, edges, paths);
    }

    private int walk(String end, ArrayList<ArrayList<String>> edges, ArrayList<ArrayList<String>> paths) {
        if (paths.isEmpty()) {
            return 0;
        }
        ArrayList<String> finishedPath = findFinishedPath(end, paths);

        if (!finishedPath.isEmpty()) {
            return finishedPath.size();
        }

        return walk(end, edges, buildPaths(paths, edges));
    }

    private ArrayList<String> findFinishedPath(String end, ArrayList<ArrayList<String>> paths) {
        return paths.stream().filter(path ->
                end.equals(path.get(path.size() - 1))
        ).findFirst().orElseGet(ArrayList::new);
    }

    private ArrayList<ArrayList<String>> buildPaths(ArrayList<ArrayList<String>> paths, ArrayList<ArrayList<String>> edges) {
        ArrayList<ArrayList<String>> newPaths = new ArrayList<>();

        for (int i = 0; i < paths.size(); i++) {
            ArrayList<String> path = paths.get(i);
            String lastWord = path.get(path.size() - 1);

            edges.stream().forEach(pair -> {
                String s1 = pair.get(0);
                String s2 = pair.get(1);

                String nextWord = null;

                if (lastWord.equals(s1) && !path.contains(s2)) {
                    nextWord = s2;
                } else if (lastWord.equals(s2) && !path.contains(s1)) {
                    nextWord = s1;
                }

                if (nextWord != null) {
                    ArrayList<String> newPath = new ArrayList<>(path);
                    newPath.add(nextWord);
                    newPaths.add(newPath);
                }
            });
        }

        return newPaths;
    }

    private ArrayList<ArrayList<String>> buildEdges(ArrayList<String> dictV) {
        ArrayList<ArrayList<String>> pairs = new ArrayList<>();

        int dictSize = dictV.size();
        for (int i = 0; i < dictSize; i++) {
            for (int j = i + 1; j < dictSize; j++) {

                String s1 = dictV.get(i);
                String s2 = dictV.get(j);
                if (oneCharDiffComparator.compare(s1, s2) == 0) {
                    ArrayList<String> pair = new ArrayList<>();
                    pair.add(s1);
                    pair.add(s2);

                    pairs.add(pair);
                }
            }
        }

        return pairs;
    }

    private static OneCharDiffComparator oneCharDiffComparator = new OneCharDiffComparator();

    private static class OneCharDiffComparator implements Comparator<String>, java.io.Serializable {

        public int compare(String s1, String s2) {
            int diff = 0;
            for (int i = 0; i < s1.length(); i++) {
                char c1 = s1.charAt(i);
                char c2 = s2.charAt(i);
                if (c1 != c2) {
                    if (diff > 0) {
                        return diff;
                    }
                    diff++;
                }
            }
            return diff - 1;
        }
    }
}
