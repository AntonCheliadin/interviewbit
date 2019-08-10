/*
 Reverse bits of an 32 bit unsigned integer
 */
public class ReverseBits {

    public static void main(String[] args) {
        System.out.println(reverse(3));
    }

    public static long reverse(long a) {
        long reversed = 0;

        for (int i = 0; i < 32; i++) {
            long lastBit = a & 1;
            reversed <<= 1;

            if (lastBit == 1) {
                reversed |= 1;
            }

            a >>= 1;
        }

        return reversed;
    }
}
