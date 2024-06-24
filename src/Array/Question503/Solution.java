package Array.Question503;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * 单调栈
 */
public class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        Arrays.fill(ans, -1);
        Deque<Integer> st = new ArrayDeque<>();
        for (int i = 0; i < 2 * n; i++) {
            int x = nums[i % n];
            while (!st.isEmpty() && x > nums[st.peek()]) {
                // x 是 nums[st.peek()] 的下一个更大元素
                // 既然 nums[st.peek()] 已经算出答案，则从栈顶弹出
                ans[st.pop()] = x;
            }
            if (i < n) {
                st.push(i);
            }
        }
        return ans;
    }
}

