package Array.Question26;

/**
 * @author ºúÁØÏè
 */
public class Solution {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        int fast = 1, slow = 1;
        while (fast < n) {
            if (nums[fast] != nums[fast - 1]) {
                nums[slow] = nums[fast];
                ++slow;
            }
            ++fast;
        }
        return slow;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 2, 4};
        Solution solution = new Solution();
        System.out.println(solution.removeDuplicates(nums));
    }
}
