package binaryIndexedTree;

public class BinaryIndexedTree {

    public static void main(String[] args) {
        int freq[] = {2, 1, 1, 3, 2, 3,
                4, 5, 6, 7, 8, 9};

        BinaryIndexedTree binaryIndexedTree = new BinaryIndexedTree(freq.length);
        binaryIndexedTree.construct(freq);

        int sum5 = binaryIndexedTree.getSum(5);

        System.out.println("Sum of elements in arr[0..5] is " + sum5);

        freq[3] += 6;

        binaryIndexedTree.update(3, 6);

        System.out.println("Sum of elements in arr[0..5] is " + binaryIndexedTree.getSum(5));
    }

    private int[] bit;

    BinaryIndexedTree(int length) {
        bit = new int[length + 1];

        initFill();
    }

    private void initFill() {
        for (int i = 1; i < bit.length; i++) {
            bit[i] = 0;
        }
    }

    void construct(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            update(i, arr[i]);
        }
    }

    int getSum(int i) {
        int sum = 0;

        int index = i + 1;

        while (index > 0) {
            sum += bit[index];

            index -= index & (-index);
        }

        return sum;
    }

    void update(int i, int val) {
        int index = i + 1;

        while (index < bit.length) {
            bit[index] += val;

            index += index & (-index);
        }
    }
}
