package Question322;

import java.util.Arrays;


/**
 * 采用自顶向下的记忆化搜索
 */
class Solution {
    //memo[n] 代表钱币可以被换取的最少的硬币数
    private int[] memo;

    public int coinChange(int[] coins, int amount) {
        if (coins.length == 0) {
            return -1;
        }
        memo = new int[amount + 1];
        return findWay(coins, amount);
    }


    public int findWay(int[] coins, int amount) {
        //说明找不到
        if (amount < 0) {
            return -1;
        }
        //0元自然只需要0个硬币
        if (amount == 0) {
            return 0;
        }
        //记忆化矩阵当中已经有了对应的缓存
        if (memo[amount] != 0) {
            return memo[amount];
        }
        //如果没有则添加缓存
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < coins.length; i++) {
            int res = findWay(coins, amount - coins[i]);
            //这一步能确保res>-1,即有找到对应的组合;且只有找到了更优解的时候，才更新min
            if (res >= 0 && res < min) {
                //加上1是因为在上一步中amount-coins[i]相当于已经兑换了一个硬币
                min = res + 1;
            }
        }
        //相当于自顶向下更新memo记忆化数组
        memo[amount] = min == Integer.MAX_VALUE ? -1 : min;
        return memo[amount];
    }


    public static void main(String[] args) {
        int[] nums = {1, 2, 5};
        int amount = 11;
        System.out.println(new Solution().coinChange(nums, amount));
    }
}