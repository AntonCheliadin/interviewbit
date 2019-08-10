public class SelectionSort {

    public static void main(String[] args) {
        var selectionSort = new SelectionSort();
        int[] sorted = selectionSort.sort(new int[]{6, 5, 4, 3, -5, 2, 1, 5, -4});
        ArrayUtil.printArray(sorted);
    }

    public int[] sort(int[] arr) {
        int[] sorted = arr.clone();

        selectionSort(sorted);

        return sorted;
    }

    private void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int min = findMin(arr, i);
            ArrayUtil.swap(arr, i, min);
        }
    }

    private int findMin(int[] arr, int start) {
        int min = start;
        for (int i = start + 1; i < arr.length; i++) {
            if (arr[i] < arr[min]) {
                min = i;
            }
        }

        return min;
    }
}
