package Array.Question122;

import java.util.Arrays;

/**
 * µÝÍÆ
 */
public class Solution1 {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] memo = new int[n + 1][2];
        for (int[] ints : memo) {
            Arrays.fill(ints, -1);
        }
        memo[0][1] = Integer.MIN_VALUE;
        memo[0][0] = 0;
        for (int i = 1; i < n + 1; i++) {
            memo[i][1] = Math.max(memo[i - 1][1], memo[i - 1][0] - prices[i - 1]);
            memo[i][0] = Math.max(memo[i - 1][0], memo[i - 1][1] + prices[i - 1]);
        }
        return memo[n][0];
    }
}
