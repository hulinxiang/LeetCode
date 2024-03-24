package Question322;


/**
 * 采用自底向上的动态规划
 * 其实无论是动态规划还是记忆化搜索，其实memo数组和dp数组的作用都差不多，只不过memo是采用的自顶向下，dp采用的是自底向上
 */
public class DpSolution {
    public int coinChange(int[] coins, int amount) {
        if (coins.length == 0) {
            return -1;
        }
        //dp[n],表示凑齐n元所需的最小硬币数
        int[] dp = new int[amount + 1];
        //0元当然只用0个硬币
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < coins.length; j++) {
                //i - coins[j]相当于加上了一个硬币
                //dp[i - coins[j]]<min相当于要找到最小值
                if (i - coins[j] >= 0 && dp[i - coins[j]] < min) {
                    min = dp[i - coins[j]] + 1;
                }
                //dp数组中没有缓存,则创建新的缓存
                dp[i] = min;
            }
        }
        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 5};
        int amount = 11;
        System.out.println(new DpSolution().coinChange(nums, amount));
    }
}
