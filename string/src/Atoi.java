public class Atoi {

    public static void main(String[] args) {
        System.out.println(atoi("-88297 248252140"));
        System.out.println(atoi("2147483646"));
        System.out.println(atoi("2147483647"));
        System.out.println(atoi("2147483648"));
        System.out.println(atoi("5121478262 8070067M75 X199R 547 8C0A11 93I630 4P4071 029W433619 M3 5 14703818 776366059B9O43393"));
        System.out.println(atoi("9 2704 01885D 9M 65291S844404U7463"));
        System.out.println(atoi("  123mmm"));
        System.out.println(atoi("  -000123mmm"));
        System.out.println(atoi("  +000123mmm"));
        System.out.println(atoi("  -0 0123mmm"));
        System.out.println(atoi("  000123mmm"));
        System.out.println(atoi("  9999999999999999999999999999999999999999999999999999123mmm"));
        System.out.println(atoi("  -999999999999999999999999999999999999999999999999999123mmm"));
    }

    public static int atoi(final String A) {
        int numberStart = getFirstDigitIndex(A);

        if (numberStart == -1) {
            return 0;
        }

        int sign = 1;

        if ('-' == A.charAt(numberStart)) {
            sign = -1;
            numberStart++;
        } else if ('+' == A.charAt(numberStart)) {
            numberStart++;
        }

        int numberLength = getNumberLength(A, numberStart);

        if (numberLength == 0) {
            return 0;
        }

        if (isNumberTooBig(A, numberStart, numberLength)) {
            return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        }

        return parseInt(A, numberStart, numberLength, sign);
    }

    private static int parseInt(final String A, int start, int length, int sign) {
        int num = 0;

        for (int i = start; i < start + length; i++) {
            int prevNum = num;

            num *= 10;
            int d = toDigit(A.charAt(i));
            num += d;

            if (prevNum != (int) (num * 0.1 - d * 0.1)) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
        }

        num *= sign;

        return num;
    }

    private static int getFirstDigitIndex(final String A) {
        for (int i = 0; i < A.length(); i++) {
            if (' ' == A.charAt(i)) {
                continue;
            }
            if ('-' == A.charAt(i) || '+' == A.charAt(i) || isDigit(A.charAt(i))) {
                return i;
            }
            break;
        }

        return -1;
    }

    private static int getNumberLength(final String A, int start) {
        int length = 0;

        while (start < A.length() && isDigit(A.charAt(start))) {
            length++;
            start++;
        }
        return length;
    }

    private static boolean isNumberTooBig(final String A, int start, int length) {
        return length >= 10 && toDigit(A.charAt(start)) > 2;
    }

    private static boolean isDigit(char c) {
        return c >= '0' && c <= '9';
    }

    private static int toDigit(char c) {
        return ((int) c) - ((int) '0');
    }
}
