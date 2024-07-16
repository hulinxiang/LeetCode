package Array.Question238;

public class Solution {


    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] pre = new int[n];
        pre[0] = 1;
        for (int i = 0; i < n - 1; i++) {
            pre[i + 1] = pre[i] * nums[i];
        }
        int suf = 1;
        for (int i = n - 1; i >= 0; i--) {
            pre[i] *= suf;
            suf *= nums[i];
        }

        return pre;
    }


}
