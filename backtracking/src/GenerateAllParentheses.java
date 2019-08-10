import java.util.ArrayList;
import java.util.Collections;

public class GenerateAllParentheses {
    /*
    Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses of length 2*n.

    For example, given n = 3, a solution set is:

    "((()))", "(()())", "(())()", "()(())", "()()()"
    Make sure the returned list of strings are sorted.
     */

    public static void main(String[] args) {
        GenerateAllParentheses solution = new GenerateAllParentheses();

        System.out.println(solution.generateParenthesis(0));
        System.out.println(solution.generateParenthesis(1));
        System.out.println(solution.generateParenthesis(2));
        System.out.println(solution.generateParenthesis(3));
        System.out.println(solution.generateParenthesis(4));
    }

    public ArrayList<String> generateParenthesis(int A) {
        return generate(A, "", 0, 0);
    }

    private ArrayList<String> generate(int A, String src, int countLeftBrackets, int countRightBrackets) {
        if (src.length() == A * 2) {
            return new ArrayList<>(Collections.singletonList(src));
        }

        ArrayList<String> result = new ArrayList<>();

        if (countLeftBrackets != A) {
            result.addAll(generate(A, src + "(", countLeftBrackets + 1, countRightBrackets));
        }
        if (countLeftBrackets > countRightBrackets) {
            result.addAll(generate(A, src + ")", countLeftBrackets, countRightBrackets + 1));
        }

        return result;
    }
}
