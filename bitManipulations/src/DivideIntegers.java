public class DivideIntegers {
    /*
    Divide two integers without using multiplication, division and mod operator.

    Return the floor of the result of the division.

    Example:

    5 / 2 = 2
    Also, consider if there can be overflow cases. For overflow case, return INT_MAX.

   dividend / divisor = quotient
   dividend = quotient * divisor + remainder

     */
    public static void main(String[] args) {
        DivideIntegers solution = new DivideIntegers();

        System.out.println(solution.divide(5, 2));
        System.out.println(solution.divide(0, 1));
        System.out.println(solution.divideBit(5, 2));
        System.out.println(solution.divideBit(0, 1));
    }

    public int divide(int dividend, int divisor) {
        int sign = ((dividend < 0) ^ (divisor < 0)) ? -1 : 1;

        dividend = Math.abs(dividend);
        divisor = Math.abs(divisor);

        int quotient = 0;

        while (dividend >= divisor) {
            dividend -= divisor;
            ++quotient;
        }

        return sign * quotient;
    }

    int divideBit(long dividend, long divisor) {
        long sign = ((dividend < 0) ^ (divisor < 0)) ? -1 : 1;

        dividend = Math.abs(dividend);
        divisor = Math.abs(divisor);

        long quotient = 0;
        long temp = 0;

// test down from the highest  bit and accumulate the tentative value for  valid bit
// 1<<31 behaves incorrectly and gives Integer Min Value which should not be the case, instead 1L<<31 works correctly.
        for (int i = 31; i >= 0; --i) {

            if (temp + (divisor << i) <= dividend) {
                temp += divisor << i;
                quotient |= 1L << i;
            }
        }

        return (int) (sign * quotient);
    }
}
