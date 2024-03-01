package Question2369;

/**
 * @author Hu
 */
public class Solution {
    /**
     * 判断标准
     * <1>两个元素一样
     * <2>三个元素一样
     * <3>三个元素递增
     *
     * @param nums
     * @return true, 如果满足以上三个条件中的任何一个;否则false
     */
    public boolean validPartition(int[] nums) {
        int len = nums.length;
        boolean[] dp = new boolean[len];
        //0默认为true
        dp[0] = true;
        if (len == 2) {
            return validTwo(nums, 0, 1);
        }
        if (len == 3) {
            return validThree(nums, 0, 2);
        }
        if (validTwo(nums, 0, 1)) {
            dp[1] = true;
        }
        if (validThree(nums, 0, 2)) {
            dp[2] = true;
        }
        for (int i = 3; i < dp.length; i++) {
            if (i > 3) {
                dp[i] = (dp[i - 3] && validThree(nums, i - 2, i)) || (dp[i - 2] && validTwo(nums, i - 1, i));
            } else {
                dp[i] = dp[i - 2] && validTwo(nums, i - 1, i);
            }
        }
        return dp[len - 1];
    }

    public boolean validTwo(int[] nums, int left, int right) {
        return nums[left] == nums[right];
    }

    public boolean validThree(int[] nums, int left, int right) {
        int a = nums[left];
        int b = nums[right - 1];
        int c = nums[right];
        if (a == b && a == c) {
            return true;
        }
        return b - a == 1 && c - b == 1;
    }


    public static void main(String[] args) {
        int[] n = new int[]{1, 2};
        Solution solution = new Solution();
        System.out.println(solution.validPartition(n));
    }
}
