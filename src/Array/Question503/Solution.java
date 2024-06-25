package Array.Question503;

import java.util.Arrays;
import java.util.Stack;

/**
 * ����ջ
 */
public class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        Stack<Integer> stack = new Stack<>();
        Arrays.fill(ans, -1);
        // 2*n �൱�ڽ�����ѭ��һ��
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

