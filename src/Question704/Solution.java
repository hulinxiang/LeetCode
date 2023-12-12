package Question704;

/**
 * 左闭右开
 */
public class Solution {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length;
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] > target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] m = {-1, 0, 3, 5, 9, 12};
        int target = 9;
        Solution solution = new Solution();
        System.out.println(solution.search(m, target));
    }
}
