public class PrimeChecker {

    public static void main(String[] args) {
        PrimeChecker primeChecker = new PrimeChecker();

        System.out.println(primeChecker.isPrime(0));
    }

    public int isPrime(int A) {
        if (A <= 1) {
            return 0;
        }
        int upperLimit = (int) (Math.sqrt(A));

        for (int i = 2; i <= upperLimit; i++) {
            if (A % i == 0) return 0;
        }
        return 1;
    }
}
