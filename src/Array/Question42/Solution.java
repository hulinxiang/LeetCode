package Array.Question42;

public class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int[] preMax = new int[n];
        preMax[0] = height[0];
        int sufmax = height[n - 1];
        // ����ǰ׺����,��
        for (int i = 1; i < n; i++) {
            // preMax[i] ��ʾ�� height[0] �� height[i]�����ֵ,[0,i]
            preMax[i] = Math.max(preMax[i - 1], height[i]);
        }
        int ans = 0;
        for (int i = n - 2; i >= 0; i--) {
            sufmax = Math.max(sufmax, height[i]);
            ans += Math.min(sufmax, preMax[i]) - height[i];
        }
        // ǰ׺�ͺ�׺���鹹����ϣ���ʼ���ans

        return ans;
    }
}
