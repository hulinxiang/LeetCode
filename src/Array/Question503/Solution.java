package Array.Question503;

import java.util.Arrays;
import java.util.Stack;

/**
 * 单调栈
 */
public class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        Stack<Integer> stack = new Stack<>();
        Arrays.fill(ans, -1);
        // 2*n 相当于将数组循环一遍
        for (int i = 0; i < 2 * n; i++) {
            int cur = nums[i % n];
            while (!stack.isEmpty() && cur > nums[stack.peek()]) {
                ans[stack.pop()] = cur;
            }
            if (i < n) {
                stack.push(i);
            }
        }
        return ans;
    }
}

