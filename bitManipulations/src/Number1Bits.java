/*
 Write a function that takes an unsigned integer and returns the number of 1 bits it has.
 */
public class Number1Bits {

    public static void main(String[] args) {
        int a = 29;

        System.out.println(numSetBits(a) + "==" + numSetBitsByLib(a));
    }

    public static int numSetBits(long a) {
        int counter = 0;

        while (a != 0) {
            long lastBit = a & 1;

            if (lastBit == 1) {
                counter++;
            }

            a = a >> 1;
        }

        return counter;
    }

    public static int numSetBitsByLib(long a) {
        String binaryString = Long.toBinaryString(a);
        return binaryString.replaceAll("0", "").length();
    }
}
