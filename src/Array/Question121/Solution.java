package Array.Question121;

public class Solution {

    public int maxProfit(int[] prices) {
        int minPrice = prices[0];
        int ret = 0;
        for (int price : prices) {
            ret = Math.max(ret, price - minPrice);
            minPrice = Math.min(price, minPrice);
        }
        return ret;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
    }
}
