package Array.Question503;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * ����ջ
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
                // x �� nums[st.peek()] ����һ������Ԫ��
                // ��Ȼ nums[st.peek()] �Ѿ�����𰸣����ջ������
                ans[st.pop()] = x;
            }
            if (i < n) {
                st.push(i);
            }
        }
        return ans;
    }
}

