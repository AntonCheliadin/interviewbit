public class Stairs {
    /*
    You are climbing a stair case and it takes A steps to reach to the top.
    Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

    Input Format:
    The first and the only argument contains an integer A, the number of steps.

    Output Format:
    Return an integer, representing the number of ways to reach the top.
     */

    public int climbStairs(int A) {
        if (A < 3) {
            return A;
        }

        int[] dp = new int[A];
        dp[0] = 1;
        dp[1] = 2;

        for (int i = 2; i < A; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[A - 1];
    }
}
