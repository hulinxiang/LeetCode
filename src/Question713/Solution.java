package Question713;

/**
 * @author ������
 */
public class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int n = nums.length;
        int ans = 0;
        int cur = 1;
        //j ��ʾ�������ڵ����; i ��ʾ�������ڵ��Ҷ�
        int j = 0;
        //��Ԫ���ۻ���˼��㵱ǰ���۳�ֵ
        for (int i = 0; i < n; i++) {
            cur *= nums[i];
            while (j <= i && cur >= k) {
                cur /= nums[j];
                j++;
            }
            //��һ���ǻ������ڵĺ���
            //  nums[right]
            //  nums[right-1], nums[right]
            //  nums[right-2], nums[right-1], nums[right]
            //  nums[left], ......, nums[right-2], nums[right-1], nums[right]
            //���� right - left + 1 ��
            //�൱��ֻ����ÿ����ָ�������ƶ��仯ʱ,�Ż���������ӵ��������
            ans += i - j + 1;
        }
        return ans;
    }
}
