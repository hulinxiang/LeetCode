package SlidingWindow.Question2009;

import java.util.Arrays;

public class Solution {
    public int minOperations(int[] nums) {
        int ans = 0;
        int left = 0;
        int m = 0;
        int len = nums.length;
        //���ȶ�������дӴ�С��������
        Arrays.sort(nums);
        //ԭ��ȥ��
        for (int i = 1; i < len; i++) {
            if (nums[i] != nums[i - 1]) {
                nums[++m] = nums[i];
            }
        }
        //�������ԭ��ȥ��֮��,nums��������m����һ����Ԫ��
        for (int i = 0; i <= m; i++) {
            //leftBorder ��������߽�
            int leftBorder = nums[i] - len + 1;
            while (nums[left] < leftBorder) {
                left++;
            }
            //����һ��ѭ��������ж���Ԫ�ز���
            ans = Math.max(ans, i - left + 1);
        }
        return len - ans;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{4, 2, 5, 3};
        Solution solution=new Solution();
        System.out.println(solution.minOperations(nums));

    }
}
