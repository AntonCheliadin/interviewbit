public class RomanToInteger {
    /*
    Given a string A representing a roman numeral.
    Convert A into integer.

    A is guaranteed to be within the range from 1 to 3999.

    Symbol	I	V	X	L	C	D	M
    Value	1	5	10	50	100	500	1,000
     */

    public static void main(String[] args) {
        RomanToInteger solution = new RomanToInteger();

        System.out.println("444=" + solution.romanToInt("CDXLIV"));
        System.out.println("1776=" + solution.romanToInt("MDCCLXXVI"));
    }

    public int romanToInt(String A) {
        int n = 0;
        int lastCharIndex = A.length() - 1;

        for (int i = 0; i < lastCharIndex; i++) {
            int curr = romanSymbolToInt(A.charAt(i));
            int next = romanSymbolToInt(A.charAt(i + 1));

            if (curr >= next) {
                n += curr;
            } else {
                n -= curr;
            }
        }
        n += romanSymbolToInt(A.charAt(lastCharIndex));

        return n;
    }

    private int romanSymbolToInt(char c) {
        switch (c) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
                throw new RuntimeException("Unknown symbol.");
        }
    }
}
