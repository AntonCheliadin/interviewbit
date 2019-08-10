public class HeapSort {

    public static void main(String[] args) {
        HeapSort heapSort = new HeapSort();

        int[] arr = {11, 2, 9, 13, 57, 25, 17, 1, 90, 3};
        heapSort.sort(arr);

        ArrayUtil.printArray(arr);
    }

    void sort(int[] arr) {
        int length = arr.length;
        for (int i = (length / 2) - 1; i >= 0; i--) {
            heapify(arr, length, i);
        }

        for (int i = length - 1; i >= 0; i--) {
            int swap = arr[i];
            arr[i] = arr[0];
            arr[0] = swap;

            heapify(arr, i, 0);
        }
    }

    private void heapify(int[] arr, int n, int i) {
        int largest = i;
        int leftChild = i * 2 + 1;
        int rightChild = i * 2 + 2;

        if (leftChild < n && arr[largest] < arr[leftChild]) {
            largest = leftChild;
        }

        if (rightChild < n && arr[largest] < arr[rightChild]) {
            largest = rightChild;
        }

        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            heapify(arr, n, largest);
        }
    }
}
