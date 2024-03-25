package Question518;


/**
 * 给你一个整数数组 coins 表示不同面额的硬币，另给一个整数 amount 表示总金额。
 * <p>
 * 请你计算并返回可以凑成总金额的硬币组合数。如果任何硬币组合都无法凑出总金额，返回 0 。
 * <p>
 * 假设每一种面额的硬币有无限个。
 * <p>
 * 题目数据保证结果符合 32 位带符号整数。
 * 本题与322非常类似
 */

public class Solution {
    //dp[n]代表总量为n的钱有多少种组合方式
    private int[] dp;

    public int change(int amount, int[] coins) {
        dp = new int[amount + 1];
        //凑齐0元只有一种组合方式，那就是大家都不选
        dp[0] = 1;
        //注意不能颠倒for循环的次序
        for (int coin : coins) {
            for (int i = 1; i <= amount; i++) {
                //在最后一个硬币中选择了''coin''
                //那么dp[i]就等于dp[i-coin]
                if (i - coin >= 0) {
                    dp[i] += dp[i - coin];
                }
            }
        }
        return dp[amount];
    }


    public static void main(String[] args) {
        int[] coins = {1, 2, 5};
        int amount = 5;
        System.out.println(new Solution().change(amount, coins));
    }

}
