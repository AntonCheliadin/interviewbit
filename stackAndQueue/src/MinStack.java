import java.util.Arrays;

/*
Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

push(x) – Push element x onto stack.
pop() – Removes the element on top of the stack.
top() – Get the top element.
getMin() – Retrieve the minimum element in the stack.

Note that all the operations have to be constant time operations.
 */
public class MinStack {

    private int[] stack = new int[10];
    private int[] stackMin = new int[10];
    private int index = -1;

    public void push(int x) {
        if (index == stack.length - 1) {
            increaseArray();
        }
        stack[index + 1] = x;

        if (index == -1 || x < getMin()) {
            stackMin[index + 1] = x;
        } else {
            stackMin[index + 1] = stackMin[index];
        }

        index++;
    }

    public void pop() {
        if (index != -1) {
            index--;
        }
    }

    public int top() {
        if (index == -1) {
            return -1;
        }
        return stack[index];
    }

    public int getMin() {
        if (index == -1) {
            return -1;
        }
        return stackMin[index];
    }

    private void increaseArray() {
        int length = stack.length;

        stack = Arrays.copyOf(stack, length * 2);
        stackMin = Arrays.copyOf(stackMin, length * 2);
    }
}
