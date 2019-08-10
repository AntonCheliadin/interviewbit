public class InsertionSort {

    public static void main(String[] args) {
        InsertionSort insertionSort = new InsertionSort();
        int[] sorted = insertionSort.sort(new int[]{6, 5, 4, 3, -5, 2, 1, 5, -4});
        ArrayUtil.printArray(sorted);
    }

    public int[] sort(int[] srcArray) {
        int[] sortedArr = srcArray.clone();

        for (int i = 1; i < sortedArr.length; i++) {
            int key = sortedArr[i];

            for (int j = i; j > 0 && key < sortedArr[j - 1]; j--) {
                sortedArr[j] = sortedArr[j - 1];
                sortedArr[j - 1] = key;
            }
        }

        return sortedArr;
    }
}