public class SquareRoot {

    public static void main(String[] args) {
        SquareRoot squareRoot = new SquareRoot();

        System.out.println(squareRoot.sqrt(2147483647));
    }

    public int sqrt(int a) {
        long half = a / 2;

        while (half * half > a) {
            half = half / 2;
        }

        while (half * half <= a) {
            half++;
        }

        return (int) (half - 1);
    }
}
