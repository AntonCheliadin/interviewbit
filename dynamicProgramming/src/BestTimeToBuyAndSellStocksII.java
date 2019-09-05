import java.util.List;

public class BestTimeToBuyAndSellStocksII {
    /*
    Say you have an array, A, for which the ith element is the price of a given stock on day i.
    Design an algorithm to find the maximum profit.
    You may complete as many transactions as you like (i.e., buy one and sell one share of the stock multiple times).
    However, you may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
    
    Input Format:
    The first and the only argument is an array of integer, A.
    
    Output Format:
    Return an integer, representing the maximum possible profit.
    
    Constraints:
    1 <= len(A) <= 1e5
    1 <= A[i] <= 1e7
    
    Example :
    Input 1:
        A = [1, 2, 3]
    Output 1:
        2
    Explanation 1:
        => Buy a stock on day 0.
        => Sell the stock on day 1. (Profit +1)
        => Buy a stock on day 1.
        => Sell the stock on day 2. (Profit +1)

        Overall profit = 2

    Input 2:
        A = [5, 2, 10]
    Output 2:
        8
    Explanation 2:
        => Buy a stock on day 1.
        => Sell the stock on on day 2. (Profit +8)

        Overall profit = 8

     */
    public static void main(String[] args) {
        BestTimeToBuyAndSellStocksII solution = new BestTimeToBuyAndSellStocksII();

        System.out.println(solution.maxProfit(List.of(1, 2, 3)));
        System.out.println(solution.maxProfit(List.of(5, 2, 10)));
        System.out.println(solution.maxProfit(List.of(5, 2, 10, 10, 100, 1, 2, 3, 4, 5, 6, 7, 8, 9, 1000, 2000, 1999)));
    }

    public int maxProfit(final List<Integer> A) {
        int profit = 0;

        for (int i = 0; i < A.size() - 1; i++) {
            Integer curr = A.get(i);
            Integer next = A.get(i + 1);
            if (curr < next) {
                profit += next - curr;
            }
        }

        return profit;
    }
}
