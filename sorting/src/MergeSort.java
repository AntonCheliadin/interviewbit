public class MergeSort {

    public static void main(String[] args) {
        var mergeSort = new MergeSort();
        int[] sorted = mergeSort.sort(new int[]{6, 5, 4, 3, -5, 2, 1, 5, -4});
        ArrayUtil.printArray(sorted);
    }

    public int[] sort(int[] arr) {
        int[] sorted = arr.clone();

        sorted = mergeSort(sorted, 0, sorted.length);

        return sorted;
    }

    private int[] mergeSort(int[] arr, int from, int to) {
        if (from + 1 == to) {
            return new int[]{arr[from]};
        }

        int center = (from + to) / 2;

        int[] arrLeft = mergeSort(arr, from, center);
        int[] arrRight = mergeSort(arr, center, to);

        return merge(arrLeft, arrRight);
    }

    private int[] merge(int[] arr1, int[] arr2) {
        int i = 0;
        int j = 0;
        int k = 0;

        int[] merged = new int[arr1.length + arr2.length];

        while (i < arr1.length && j < arr2.length) {

            if (arr1[i] < arr2[j]) {
                merged[k++] = arr1[i];
                i++;
            } else {
                merged[k++] = arr2[j];
                j++;
            }
        }

        while (i < arr1.length) {
            merged[k++] = arr1[i++];
        }

        while (j < arr2.length) {
            merged[k++] = arr2[j++];
        }

        return merged;
    }
}
