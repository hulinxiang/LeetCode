package Array.Question122;

/**
 * �ݹ��ٽ��ף�ֻ�����������������Ӧ��״̬
 */
public class Solution2 {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        // һ��ʼ��ʱ��δ���й�ƱΪ0
        int f0 = 0;
        // һ��ʼ��ʱ����й�ƱΪ�Ƿ�
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
