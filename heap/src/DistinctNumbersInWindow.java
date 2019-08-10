import java.util.*;

public class DistinctNumbersInWindow {
    /*
    You are given an array of N integers, A1, A2 ,…, AN and an integer K.
    Return the of count of distinct numbers in all windows of size K.

    Formally, return an array of size N-K+1
    where i’th element in this array contains number of distinct elements in sequence Ai, Ai+1 ,…, Ai+k-1.

    For example,
    A=[1, 2, 1, 3, 4, 3] and K = 3

    All windows of size K are

    [1, 2, 1]
    [2, 1, 3]
    [1, 3, 4]
    [3, 4, 3]

    So, we return an array [2, 3, 3, 2].
     */

    public static void main(String[] args) {
        DistinctNumbersInWindow solution = new DistinctNumbersInWindow();
        ArrayList<Integer> dNums = solution.dNums(new ArrayList<>(List.of(1, 2, 1, 3, 4, 3)), 3);

        System.out.println(dNums);
    }

    public ArrayList<Integer> dNums(ArrayList<Integer> A, int B) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < B; i++) {
            addToMap(map, A.get(i));
        }

        ArrayList<Integer> result = new ArrayList<>();
        result.add(map.keySet().size());

        for (int i = 0; i < A.size() - B; i++) {
            removeFromMap(map, A.get(i));
            addToMap(map, A.get(i + B));
            result.add(map.keySet().size());
        }

        return result;
    }

    private void addToMap(Map<Integer, Integer> map, int val) {
        Integer countNext = map.getOrDefault(val, 0);
        map.put(val, countNext + 1);
    }

    private void removeFromMap(Map<Integer, Integer> map, int val) {
        Integer countLast = map.get(val);
        if (countLast > 1) {
            map.put(val, countLast - 1);
        } else {
            map.remove(val);
        }
    }
}
