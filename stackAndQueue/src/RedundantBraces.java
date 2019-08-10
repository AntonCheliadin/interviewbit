import java.util.Stack;

public class RedundantBraces {

    public static void main(String[] args) {
        RedundantBraces redundantBraces = new RedundantBraces();

        System.out.println("er=1; ar=" + redundantBraces.braces("((a + b))"));
        System.out.println("er=0; ar=" + redundantBraces.braces("(a + (a + b))"));
    }

    public int braces(String A) {

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < A.length(); i++) {
            char c = A.charAt(i);
            if ('(' == c || isOperand(c)) {
                stack.add(c);
            } else if (')' == c) {
                boolean operatorExists = false;
                while ('(' != stack.peek()) {
                    if (isOperand(stack.pop())) {
                        operatorExists = true;
                    }
                }
                if (!operatorExists) {
                    return 1;
                }
                stack.pop();
            }
        }

        return 0;
    }

    private boolean isOperand(char s) {
        return '+' == s || '-' == s || '*' == s || '/' == s;
    }
}
