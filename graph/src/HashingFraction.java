import java.util.HashMap;

public class HashingFraction {
    /*
    Given two integers representing the numerator and denominator of a fraction, return the fraction in string format.

    If the fractional part is repeating, enclose the repeating part in parentheses.

    Example :

    Given numerator = 1, denominator = 2, return "0.5"
    Given numerator = 2, denominator = 1, return "2"
    Given numerator = 2, denominator = 3, return "0.(6)"
     */

    public static void main(String[] args) {
        HashingFraction solution = new HashingFraction();
        System.out.println(solution.fractionToDecimal(-1, 2));
        System.out.println(solution.fractionToDecimal(2, 1));
        System.out.println(solution.fractionToDecimal(1, 2));
        System.out.println(solution.fractionToDecimal(2, 3));
        System.out.println(solution.fractionToDecimal(-2147483648, -1));
        System.out.println(solution.fractionToDecimal(-1, -2147483648));
        System.out.println(solution.fractionToDecimal(87, 22));
        System.out.println(solution.fractionToDecimal(987, 922));
        System.out.println(solution.fractionToDecimal(593, 88));
        System.out.println(solution.fractionToDecimal(945, 103));
        System.out.println(solution.fractionToDecimal(243, 543));
        System.out.println(solution.fractionToDecimal(836, 78));
    }

    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0)
            return "0";
        if (denominator == 0)
            return "";

        String result = "";

        // is result is negative
        if ((numerator < 0) ^ (denominator < 0)) {
            result += "-";
        }

        // convert int to long
        long num = numerator, den = denominator;
        num = Math.abs(num);
        den = Math.abs(den);

        // quotient
        long res = num / den;
        result += String.valueOf(res);

        // if remainder is 0, return result
        long remainder = (num % den) * 10;
        if (remainder == 0)
            return result;

        // right-hand side of decimal point
        HashMap<Long, Integer> startPositionByRemainder = new HashMap<Long, Integer>();
        result += ".";
        while (remainder != 0) {
            // if digits repeat
            if (startPositionByRemainder.containsKey(remainder)) {
                int beg = startPositionByRemainder.get(remainder);
                String part1 = result.substring(0, beg);
                String part2 = result.substring(beg);
                result = part1 + "(" + part2 + ")";
                return result;
            }

            // continue
            startPositionByRemainder.put(remainder, result.length());
            res = remainder / den;
            result += String.valueOf(res);
            remainder = (remainder % den) * 10;
        }

        return result;
    }
}
