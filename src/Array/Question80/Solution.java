package Array.Question80;

import java.util.Arrays;

public class Solution {
    public int removeDuplicates(int[] nums) {
        int slow = 2;
        int fast = 2;
        int n = nums.length;
        while (fast < n) {
            if (nums[fast] == nums[slow - 2]) {
                //当前元素不应该被保留
                fast++;
            } else {
                nums[slow++] = nums[fast++];
            }
        }
        return slow;
    }

    public static void main(String[] args) {
        int[] ints = {1, 1, 1, 2, 2, 3};
        new Solution().removeDuplicates(ints);
        System.out.println(Arrays.toString(ints));
    }
}
