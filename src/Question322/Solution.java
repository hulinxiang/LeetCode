package Question322;

import java.util.Arrays;


/**
 * �����Զ����µļ��仯����
 */
class Solution {
    //memo[n] ����Ǯ�ҿ��Ա���ȡ�����ٵ�Ӳ����
    private int[] memo;

    public int coinChange(int[] coins, int amount) {
        if (coins.length == 0) {
            return -1;
        }
        memo = new int[amount + 1];
        return findWay(coins, amount);
    }


    public int findWay(int[] coins, int amount) {
        //˵���Ҳ���
        if (amount < 0) {
            return -1;
        }
        //0Ԫ��Ȼֻ��Ҫ0��Ӳ��
        if (amount == 0) {
            return 0;
        }
        //���仯�������Ѿ����˶�Ӧ�Ļ���
        if (memo[amount] != 0) {
            return memo[amount];
        }
        //���û������ӻ���
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < coins.length; i++) {
            int res = findWay(coins, amount - coins[i]);
            //��һ����ȷ��res>-1,�����ҵ���Ӧ�����;��ֻ���ҵ��˸��Ž��ʱ�򣬲Ÿ���min
            if (res >= 0 && res < min) {
                //����1����Ϊ����һ����amount-coins[i]�൱���Ѿ��һ���һ��Ӳ��
                min = res + 1;
            }
        }
        //�൱���Զ����¸���memo���仯����
        memo[amount] = min == Integer.MAX_VALUE ? -1 : min;
        return memo[amount];
    }


    public static void main(String[] args) {
        int[] nums = {1, 2, 5};
        int amount = 11;
        System.out.println(new Solution().coinChange(nums, amount));
    }
}