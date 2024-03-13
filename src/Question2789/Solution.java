package Question2789;

public class Solution {
    public long maxArrayValue(int[] nums) {
        long max = nums[nums.length - 1];
        for (int i = nums.length - 1; i >= 1; i--) {
            if (max >= nums[i - 1]) {
                max += nums[i - 1];
            } else {
                max = nums[i - 1];
            }
        }
        return max;
    }
}
