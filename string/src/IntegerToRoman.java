public class IntegerToRoman {
    /*
    Given an integer A, convert it to a roman numeral, and return a string corresponding to its roman numeral version

    Input Format
    The only argument given is integer A.

    Output Format
    Return a string denoting roman numeral version of A.

    Constraints
    1 <= A <= 3999

    For Example

    Input 1:
        A = 5
    Output 1:
        "V"

    Input 2:
        A = 14
    Output 2:
        "XIV"


        I = 1
        V = 5
        X = 10
        L = 50
        C = 100
        D = 500
        M = 1000
     */

    public static void main(String[] args) {
        IntegerToRoman integerToRoman = new IntegerToRoman();

        System.out.println(integerToRoman.intToRoman(1));
        System.out.println(integerToRoman.intToRoman(14));
        System.out.println(integerToRoman.intToRoman(44));
        System.out.println(integerToRoman.intToRoman(40));
        System.out.println(integerToRoman.intToRoman(9));
        System.out.println(integerToRoman.intToRoman(99));
        System.out.println(integerToRoman.intToRoman(3999));
    }

    private char[] romans = {
            'I', 'V',
            'X', 'L',
            'C', 'D',
            'M',
            '-', '-'
    };

    public String intToRoman(int A) {
        String s = String.valueOf(A);

        StringBuilder result = new StringBuilder();
        for (int i = s.length() - 1, level = 0; i >= 0; i--, level++) {
            int digit = Character.getNumericValue(s.charAt(i));

            char[] charsForLevel = getRomansByLevel(level);

            if (digit <= 3) {
                for (int j = 0; j < digit; j++) {
                    result.insert(0, charsForLevel[0]);
                }
            } else if (digit == 4) {
                result.insert(0, charsForLevel[1]);
                result.insert(0, charsForLevel[0]);
            } else if (digit == 5) {
                result.insert(0, charsForLevel[1]);
            } else if (digit <= 8) {
                result.insert(0, charsForLevel[1]);
                for (int j = 0; j < digit - 5; j++) {
                    result.insert(1, charsForLevel[0]);
                }
            } else if (digit == 9) {
                result.insert(0, charsForLevel[2]);
                result.insert(0, charsForLevel[0]);
            }

        }

        return result.toString();
    }

    private char[] getRomansByLevel(int level) {
        return new char[]{romans[level * 2], romans[level * 2 + 1], romans[level * 2 + 2]};
    }
}
