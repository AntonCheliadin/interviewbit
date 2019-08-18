public class GreatestCommonDivisor {
    /*
    Given 2 non negative integers m and n, find gcd(m, n)

    GCD of 2 integers m and n is defined as the greatest integer g such that g is a divisor of both m and n.
     */

    public static void main(String[] args) {
        GreatestCommonDivisor divisor = new GreatestCommonDivisor();

        System.out.println(divisor.gcd(6, 9));
        System.out.println(divisor.gcd(9, 6));
        System.out.println(divisor.gcd(0, 2));
    }

    public int gcd(int A, int B) {
        while (B != 0) {
            int r = A % B;

            A = B;
            B = r;
        }

        return A;
    }
}
