package Array.Question503;

public class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            ans[i] = getNextGreaterElement(nums, i, n);
        }
        return ans;
    }

    public int getNextGreaterElement(int[] nums, int i, int n) {
        int cur = i;
        for (int k = 0; k < n; k++) {
            cur = (cur + 1 + n) % n;
            if (nums[cur] > nums[i]) {
                return nums[cur];
            }
        }
        return -1;
    }

}
