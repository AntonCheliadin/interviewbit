public class GridUniquePaths {

    public static void main(String[] args) {
        GridUniquePaths gridUniquePaths = new GridUniquePaths();

        System.out.println(gridUniquePaths.uniquePathsByCombinatorics(3, 4));
        System.out.println(gridUniquePaths.uniquePathsByRecursive(3, 4));
        System.out.println(gridUniquePaths.uniquePathsByCombinatorics(15, 9));
        System.out.println(gridUniquePaths.uniquePathsByRecursive(15, 9));
    }

    public int uniquePathsByRecursive(int A, int B) {
        if (A == 1 || B == 1) {
            return 1;
        }

        return uniquePathsByRecursive(A - 1, B) + uniquePathsByCombinatorics(A, B - 1);
    }

    public int uniquePathsByCombinatorics(int A, int B) {
        if (A == 1 || B == 1) {
            return 1;
        }

        int b = Math.min(A, B);

        return kCn(b - 1, A + B - 2);
    }

    /*
        n!           6!          4*5*6
     ________  = __________  = _________
      k!(n-k)!    3!(6-3)!        3!
     */
    private int kCn(int k, int n) {
        return (int) (factorial(n, n - k) / factorial(k));
    }

    private long factorial(int a) {
        return factorial(a, 0);
    }

    private long factorial(int a, int ignoreFirst) {
        long fac = 1;
        for (int i = 1; i <= a; i++) {
            if (i > ignoreFirst) {
                fac *= i;
            }
        }
        return fac;
    }
}
