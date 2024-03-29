package Dp.Question1997;

class Solution {
    //������ϱ��η��ʣ����� i �ŷ���Ĵ���Ϊ ���� ����ô �ڶ��� ��Ҫ���� nextVisit[i] ��ָ���ķ��䣬���� 0 <= nextVisit[i] <= i
    //������ϱ��η��ʣ����� i �ŷ���Ĵ���Ϊ ż�� ����ô �ڶ��� ��Ҫ���� (i + 1) mod n �ŷ��䡣
    //���ȸ��ݹ۲죬�����Ҫ���ұ��ߣ�ʵ������Ԫ�صı�������ô����Ҫǰ���n�εĶ���ż���ſ���

    /**
     * ��̬�滮
     *
     * @param nextVisit һ�������˷����ŵ�����
     * @return ���з��䶼�����һ�α���ʱ���������������0��ʼ����
     */
    public int firstDayBeenInAllRooms(int[] nextVisit) {
        int mod = 1_000_000_007;
        //n �����ж���ס��
        int n = nextVisit.length;
        //��̬�滮����
        //���dp[x]����0,��ô��Ҫ�ȷ���һ��x������x��ֵ����1�ˣ�Ȼ���ٻط�һ�Σ������ٷ���x��ֵ����2��Ϊż����
        long[] dp = new long[n];
        for (int i = 0; i < n - 1; i++) {
            dp[i + 1] = (dp[i] + 1 + dp[i] - dp[nextVisit[i]] + 1 + mod) % mod;
        }

        return (int) dp[n - 1];

    }

    public static void main(String[] args) {
        System.out.println(new Solution().firstDayBeenInAllRooms(new int[]{0, 0, 2}));
    }
}
