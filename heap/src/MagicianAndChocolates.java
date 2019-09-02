import java.util.*;

public class MagicianAndChocolates {
    /*
    Given N bags, each bag contains Ai chocolates. There is a kid and a magician. In one unit of time, kid chooses a random bag i, eats Ai chocolates, then the magician fills the ith bag with floor(Ai/2) chocolates.

    Given Ai for 1 <= i <= N, find the maximum number of chocolates kid can eat in K units of time.

    For example,

    K = 3
    N = 2
    A = 6 5

    Return: 14
    At t = 1 kid eats 6 chocolates from bag 0, and the bag gets filled by 3 chocolates
    At t = 2 kid eats 5 chocolates from bag 1, and the bag gets filled by 2 chocolates
    At t = 3 kid eats 3 chocolates from bag 0, and the bag gets filled by 1 chocolate
    so, total number of chocolates eaten: 6 + 5 + 3 = 14

    Note: Return your answer modulo 10^9+7
     */
    public static void main(String[] args) {
        MagicianAndChocolates solution = new MagicianAndChocolates();

        ArrayList<Integer> list = new ArrayList<>();
        list.add(6);
        list.add(5);
        System.out.println("er = 14; ar = " + solution.nchoc(3, list));
        System.out.println("er = 14; ar = " + solution.nchocByHeap(3, list));

        list.clear();
        list.add(2147483647);
        list.add(2000000014);
        list.add(2147483647);
        System.out.println("er = 284628164; ar = " + solution.nchoc(10, list));
        System.out.println("er = 284628164; ar = " + solution.nchocByHeap(10, list));
    }

    public int nchoc(int A, ArrayList<Integer> B) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(B.size(), Comparator.reverseOrder());
        queue.addAll(B);

        long sum = 0;

        for (int i = 0; i < A; i++) {
            Integer num = queue.poll();
            sum += num;

            queue.add(num / 2);
        }

        return (int) (sum % (Math.pow(10, 9) + 7));
    }


    public int nchocByHeap(int A, ArrayList<Integer> B) {
        MaxHeap heap = new MaxHeap(B);

        long sum = 0;

        for (int i = 0; i < A; i++) {
            Integer max = heap.getMax();
            sum += max;
            heap.setMax(max / 2);
        }

        return (int) (sum % (Math.pow(10, 9) + 7));
    }

    static class MaxHeap {

        private int[] heap;

        MaxHeap(Collection<Integer> collection) {
            initHeap(collection);
            buildHeap();
        }

        public Integer getMax() {
            return heap[1];
        }

        public void setMax(int val) {
            heap[1] = val;

            heapify(1);
        }

        private void initHeap(Collection<Integer> collection) {
            heap = new int[collection.size() + 1];

            int i = 1;
            for (Integer num : collection) {
                heap[i++] = num;
            }
        }

        private void buildHeap() {
            for (int i = heap.length / 2; i >= 1; i--) {
                heapify(i);
            }
        }

        private void heapify(int i) {
            int left = 2 * i;
            int right = 2 * i + 1;

            int largest = i;

            if (heap.length > left && heap[left] > heap[largest]) {
                largest = left;
            }

            if (heap.length > right && heap[right] > heap[largest]) {
                largest = right;
            }

            if (largest != i) {
                int temp = heap[i];
                heap[i] = heap[largest];
                heap[largest] = temp;

                heapify(largest);
            }
        }
    }
}
