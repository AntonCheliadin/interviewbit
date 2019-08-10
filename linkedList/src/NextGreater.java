import java.util.*;

public class NextGreater {

    public static void main(String[] args) {
        NextGreater nextGreater = new NextGreater();

        ArrayList<Integer> a = new ArrayList<>();
//        a.addAll(List.of(48, 38, 42, 39, 28, 6, 49, 34));
//        a.addAll(List.of(34, 35, 27, 42, 5, 28, 39, 20, 28));
        a.addAll(List.of(39, 27, 11, 4, 24, 32, 32, 1));
        var res = nextGreater.nextGreater(a);

        System.out.println(res);
    }

    public ArrayList<Integer> nextGreater(ArrayList<Integer> A) {
        ArrayList<Integer> res = new ArrayList<>();
        res.add(-1);

        Stack<Integer> stack = new Stack<>();
        stack.add(A.get(A.size() - 1));

        for (int i = A.size() - 2; i >= 0; i--) {

            if (stack.size() == 1 && A.get(i) > stack.peek()) {
                stack.pop();
                stack.push(A.get(i));
                res.add(0, -1);
            } else if (A.get(i) < stack.peek()) {
                res.add(0, stack.peek());
                stack.push(A.get(i));
            } else if (A.get(i) >= stack.peek()) {

                while (!stack.isEmpty() && stack.peek() <= A.get(i)) {
                    stack.pop();
                }

                if (!stack.isEmpty()) {
                    res.add(0, stack.peek());
                } else {
                    res.add(0, -1);
                }
                stack.push(A.get(i));
            }
        }

        return res;
    }
}
