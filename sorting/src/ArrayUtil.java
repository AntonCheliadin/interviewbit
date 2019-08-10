import java.util.ArrayList;
import java.util.List;

public class ArrayUtil {

    static void printArray(int[] arr) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    static void printArray(Integer[] arr) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    static void printMatrix(ArrayList<ArrayList<Integer>> matrix) {
        for (List<Integer> nestedList : matrix) {
            for (int i : nestedList) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
