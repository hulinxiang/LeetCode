package Question518;


/**
 * ����һ���������� coins ��ʾ��ͬ����Ӳ�ң����һ������ amount ��ʾ�ܽ�
 * <p>
 * ������㲢���ؿ��Դճ��ܽ���Ӳ�������������κ�Ӳ����϶��޷��ճ��ܽ����� 0 ��
 * <p>
 * ����ÿһ������Ӳ�������޸���
 * <p>
 * ��Ŀ���ݱ�֤������� 32 λ������������
 * ������322�ǳ�����
 */

public class Solution {
    //dp[n]��������Ϊn��Ǯ�ж�������Ϸ�ʽ
    private int[] dp;

    public int change(int amount, int[] coins) {
        dp = new int[amount + 1];
        //����0Ԫֻ��һ����Ϸ�ʽ���Ǿ��Ǵ�Ҷ���ѡ
        dp[0] = 1;
        //ע�ⲻ�ܵߵ�forѭ���Ĵ���
        for (int coin : coins) {
            for (int i = 1; i <= amount; i++) {
                //�����һ��Ӳ����ѡ����''coin''
                //��ôdp[i]�͵���dp[i-coin]
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
