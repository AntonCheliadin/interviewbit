import java.util.*;

public class Anagrams {

    public static void main(String[] args) {
        Anagrams anagrams = new Anagrams();

        ArrayList<String> strings = new ArrayList<>();
        strings.addAll(List.of("cat", "dog", "left", "tac", "god", "gdo"));
        ArrayList<ArrayList<Integer>> res = anagrams.anagrams(strings);

        System.out.println(res);
    }

    public ArrayList<ArrayList<Integer>> anagrams(final List<String> A) {
        HashMap<String, ArrayList<Integer>> hashMap = new HashMap<>();

        for (int i = 0; i < A.size(); i++) {
            String token = token(A.get(i));

            ArrayList<Integer> list = hashMap.getOrDefault(token, new ArrayList<>());

            list.add(i + 1);
            hashMap.put(token, list);

        }
        return new ArrayList<>(hashMap.values());
    }

    private String token(String s) {
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        return String.valueOf(chars);
    }
}
