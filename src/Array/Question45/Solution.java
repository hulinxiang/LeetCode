package Array.Question45;

import java.util.Arrays;


/**
 * DP
 */
public class Solution {
    int[] memo;

    public int jump(int[] nums) {
        int n = nums.length;
        int min = 0;
        Arrays.fill(memo, Integer.MAX_VALUE);
        memo[0] = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 1; j <= nums[i]; j++) {
                if (i + j < n) {
                    memo[i + j] = Math.min(memo[i] + 1, memo[i + j]);
                }
            }
        }
        return memo[n - 1];
    }

    public static void main(String[] args) {
        int[] nums = {1, 2};
        System.out.println(new Solution().jump(nums));
    }


}
