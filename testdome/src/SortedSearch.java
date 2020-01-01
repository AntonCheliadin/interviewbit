import java.util.stream.Stream;

/*
Implement function countNumbers that accepts a sorted array of unique integers and,
efficiently with respect to time used, counts the number of array elements that are less than the parameter lessThan.

 */
public class SortedSearch {
    public static int countNumbers(int[] sortedArray, int lessThan) {
        if (sortedArray[0] >= lessThan) {
            return 0;
        } else if (sortedArray[sortedArray.length - 1] < lessThan) {
            return sortedArray.length;
        }

        int from = 0;
        int to = sortedArray.length - 1;
        int i = (from + to) / 2;

        while (!(sortedArray[i] < lessThan && sortedArray[i + 1] >= lessThan)) {
            if (sortedArray[i] >= lessThan) {
                to = i;
            } else {
                from = i;
            }

            i = (from + to) / 2;
        }

        return i + 1;
    }

    public static void main(String[] args) {
        System.out.println(SortedSearch.countNumbers(new int[]{1, 3, 5, 7}, 4));
    }
}