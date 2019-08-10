import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RemoveDuplicates {

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.addAll(List.of(1, 2, 3, 3, 3, 4, 4, 5, 5, 5, 5, 5, 5, 6));
        System.out.println(removeDuplicates(list) + "=" + list);

        list = new ArrayList<>();
        list.addAll(List.of(500, 500, 500));
        System.out.println(removeDuplicates(list) + "=" + list);

        list = new ArrayList<>();
        list.addAll(List.of(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3));
        System.out.println(removeDuplicates(list) + "=" + list);

        Integer[] uniqueArray = removeDuplicatesFromArray(new Integer[]{1, 2, 3, 3, 3, 4, 4, 5, 5, 5, 5, 5, 5, 6});
        ArrayUtil.printArray(uniqueArray);
    }

    public static int removeDuplicates(ArrayList<Integer> a) {
        int i = a.size() - 1;
        int prev = a.get(i--);

        while (i >= 0) {
            if (a.get(i).equals(prev)) {
                a.remove(i);
            } else {
                prev = a.get(i);
            }
            i--;
        }

        return a.size();
    }


    public static Integer[] removeDuplicatesFromArray(Integer[] b) {
        int lastUniqueI = 0;
        for (int i = 1; i < b.length; i++) {
            if (!b[i].equals(b[lastUniqueI])) {
                lastUniqueI++;

                if (lastUniqueI < i) {
                    swap(b, i, lastUniqueI);
                }
            }
        }

        return Arrays.copyOfRange(b, 0, lastUniqueI + 1);
    }

    static void swap(Integer[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
