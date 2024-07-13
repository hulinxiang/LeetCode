package Array.Question122;

/**
 * 递归再进阶，只用两个变量来保存对应的状态
 */
public class Solution2 {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        // 一开始的时候未持有股票为0
        int f0 = 0;
        // 一开始的时候持有股票为非法
        int f1 = Integer.MIN_VALUE;
        for (int price : prices) {
            int newF0 = Math.max(f0, f1 + price);
            int newF1 = Math.max(f1, f0 - price);
            f0 = Math.max(f0, newF0);
            f1 = Math.max(f1, newF1);
        }
        return f0;
    }
}
