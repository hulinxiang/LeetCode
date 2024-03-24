package Question322;


/**
 * �����Ե����ϵĶ�̬�滮
 * ��ʵ�����Ƕ�̬�滮���Ǽ��仯��������ʵmemo�����dp��������ö���ֻ࣬����memo�ǲ��õ��Զ����£�dp���õ����Ե�����
 */
public class DpSolution {
    public int coinChange(int[] coins, int amount) {
        if (coins.length == 0) {
            return -1;
        }
        //dp[n],��ʾ����nԪ�������СӲ����
        int[] dp = new int[amount + 1];
        //0Ԫ��Ȼֻ��0��Ӳ��
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < coins.length; j++) {
                //i - coins[j]�൱�ڼ�����һ��Ӳ��
                //dp[i - coins[j]]<min�൱��Ҫ�ҵ���Сֵ
                if (i - coins[j] >= 0 && dp[i - coins[j]] < min) {
                    min = dp[i - coins[j]] + 1;
                }
                //dp������û�л���,�򴴽��µĻ���
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
