import java.util.ArrayList;

public class AllFactors {

    public static void main(String[] args) {
        System.out.println(allFactors(82944));
    }

    public static ArrayList<Integer> allFactors(int A) {
        ArrayList<Integer> ret = new ArrayList<Integer>();

        for (int i = 1; i <= Math.sqrt(A); i++) {
            if (A % i == 0) {
                ret.add(i);
            }
        }

        int initialFactorsSize = ret.size();

        for (int i = initialFactorsSize - 1; i > 0; i--) {
            int j = A / ret.get(i);
            if (ret.get(ret.size() - 1) != j) {
                ret.add(j);
            }
        }

        if (ret.get(ret.size() - 1) != A) {
            ret.add(A);
        }

        return ret;
    }
}
