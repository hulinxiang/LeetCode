package Question2549;

import java.util.Stack;

/**
 * @author Hu
 */
public class Solution {
    private int[] arr = new int[101];
    private Stack<Integer> stacks = new Stack<Integer>();

    //对于出现在桌面上的每个数字 x ，找出符合 1 <= i <= n 且满足 x % i == 1 的所有数字 i 。
    public int distinctIntegers(int n) {
        int ans = 1;
        stacks.push(n);
        arr[n] = 1;
        while (!stacks.isEmpty()) {
            int x = stacks.pop();
            for (int i = 1; i <= n; i++) {
                if (x % i == 1 && arr[i] != 1) {
                    arr[i] = 1;
                    stacks.push(i);
                    ans++;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().distinctIntegers(5));
    }
}
