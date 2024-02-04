package Question1944;

import java.util.Arrays;
import java.util.Stack;

public class Solution {
    public int[] canSeePersonsCount(int[] heights) {
        int len = heights.length;
        int[] ans = new int[len];
        Stack<Integer> stack = new Stack<>();

        for (int i = len - 1; i >= 0; i--) {
            int count = 0;
            while (!stack.isEmpty() && heights[i] > stack.peek()) {
                stack.pop();
                count++;
            }
            if (!stack.isEmpty()) {
                count++;
            }
            ans[i] = count;
            stack.push(heights[i]);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] heights= {10,6,8,5,11,9};
        System.out.println(Arrays.toString(new Solution().canSeePersonsCount(heights)));
    }
}
