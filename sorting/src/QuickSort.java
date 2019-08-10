public class QuickSort {


    public static void main(String[] args) {
        var quickSort = new QuickSort();
        int[] arr = {6, 5, 4, 3, -5, 2, 1, 5, -4, 0};
        quickSort.sort(arr);
        ArrayUtil.printArray(arr);
    }

    public int[] sort(int[] arr) {
        int[] sorted = arr.clone();

        quickSort(sorted, 0, arr.length - 1);

        return sorted;
    }

    private void quickSort(int[] arr, int start, int end) {
        if (start >= end) {
            return;
        }

        int pivot = partition(arr, start, end);

        quickSort(arr, start, pivot - 1);
        quickSort(arr, pivot + 1, end);
    }

    private int partition(int[] arr, int start, int end) {
        int pivot = arr[end];

        int lowestRightSublist = start;
        int i = start - 1;

        while (++i < end) {
            if (arr[i] < pivot) {
                ArrayUtil.swap(arr, lowestRightSublist, i);
                lowestRightSublist++;
            }
        }

        ArrayUtil.swap(arr, end, lowestRightSublist);

        return lowestRightSublist;
    }
}
