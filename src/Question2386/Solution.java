package Question2386;

import java.util.Arrays;

public class Solution {
    private int cnt;

    public long kSum(int[] nums, int k) {
        long sum = 0, right = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= 0) {
                sum += nums[i];
            } else {
                nums[i] = -nums[i];
            }
            right += nums[i];
        }
        Arrays.sort(nums);

        long left = -1;
        while (left + 1 < right) {
            long mid = (left + right) / 2;
            cnt = k - 1;
            dfs(0, mid, nums);
            if (cnt == 0) {
                right = mid;
            } else {
                left = mid;
            }
        }
        return sum - right;
    }

    private void dfs(int i, long s, int[] nums) {
        if (cnt == 0 || i == nums.length || s < nums[i]) {
            return;
        }
        cnt--;
        dfs(i + 1, s - nums[i], nums);
        dfs(i + 1, s, nums);
    }


}
