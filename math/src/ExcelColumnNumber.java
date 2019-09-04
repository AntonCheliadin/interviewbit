public class ExcelColumnNumber {
    /*
    Given a column title as appears in an Excel sheet, return its corresponding column number.

    Example:
        A -> 1
        B -> 2
        C -> 3
        ...
        Z -> 26
        AA -> 27
        AB -> 28

        BA -> 53
     */

    public static void main(String[] args) {
        ExcelColumnNumber excelColumnNumber = new ExcelColumnNumber();

        System.out.println(excelColumnNumber.titleToNumber("BA"));
        System.out.println(excelColumnNumber.titleToNumber2("BA"));
    }

    public int titleToNumber(String A) {
        char[] chars = A.toCharArray();

        int base = 'A' - 1;
        int sum = 0;

        for (int i = chars.length - 1, pow = 0; i >= 0; i--, pow++) {
            sum += Math.pow(26, pow) * (chars[i] - base);
        }

        return sum;
    }

    public int titleToNumber2(String A) {
        char[] chars = A.toCharArray();

        int sum = 0;

        for (int i = 0; i < chars.length; i++) {
            sum = sum * 26 + (chars[i] - 'A' + 1);
        }

        return sum;
    }
}
