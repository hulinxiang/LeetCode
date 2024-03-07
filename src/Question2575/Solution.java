package Question2575;

import java.util.Arrays;

public class Solution {
    public int[] divisibilityArray(String word, int m) {
        int len = word.length();
        int[] ans = new int[len];
        int cur = 0;
        for (int i = 0; i < len; i++) {
            int charAtIndex = word.charAt(i) - '0';
            cur = 10 * cur + charAtIndex;
            cur = cur % m;
            if (cur == 0) {
                ans[i] = 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.divisibilityArray("1010", 10)));
    }
}
