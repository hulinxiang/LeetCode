package SlidingWindow.Question2009;

import java.util.Arrays;

public class Solution {
    public int minOperations(int[] nums) {
        int ans = 0;
        int left = 0;
        int m = 0;
        int len = nums.length;
        //首先对数组进行从大到小进行排序
        Arrays.sort(nums);
        //原地去重
        for (int i = 1; i < len; i++) {
            if (nums[i] != nums[i - 1]) {
                nums[++m] = nums[i];
            }
        }
        //在完成了原地去重之后,nums数组中有m个不一样的元素
        for (int i = 0; i <= m; i++) {
            //leftBorder 代表了左边界
            int leftBorder = nums[i] - len + 1;
            while (nums[left] < leftBorder) {
                left++;
            }
            //在这一轮循环中最多有多少元素不变
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
