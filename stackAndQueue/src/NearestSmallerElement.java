import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class NearestSmallerElement {
    /*
    Given an array, find the nearest smaller element G[i] for every element A[i] in the array such that the element has an index smaller than i.

    More formally,

        G[i] for an element A[i] = an element A[j] such that
        j is maximum possible AND
        j < i AND
        A[j] < A[i]
    Elements for which no smaller element exist, consider next smaller element as -1.
     */

    public static void main(String[] args) {
        NearestSmallerElement solution = new NearestSmallerElement();

        System.out.println(solution.prevSmaller(new ArrayList<>(List.of(4, 5, 2, 10, 8))));
        System.out.println(solution.prevSmaller(new ArrayList<>(List.of(3, 2, 1))));
        System.out.println(solution.prevSmaller(new ArrayList<>(List.of(4, 24, 32, 32, 1))));
    }

    public ArrayList<Integer> prevSmaller(ArrayList<Integer> A) {
        Stack<Integer> stack = new Stack<>();
        ArrayList<Integer> result = new ArrayList<>();

        for (int i = 0; i < A.size(); i++) {
            Integer currentValue = A.get(i);

            while (!stack.isEmpty() && stack.peek() >= currentValue) {
                stack.pop();
            }

            if (stack.isEmpty()) {
                result.add(-1);
            } else {
                result.add(stack.peek());
            }
            stack.push(currentValue);
        }

        return result;
    }
}
