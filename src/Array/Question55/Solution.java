package Array.Question55;

public class Solution {

    public boolean canJump(int[] nums) {
        int mx = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > mx) {
                break;
            }
            mx = Math.max(mx, i + nums[i]);

        }
        return mx >= nums.length - 1;

    }


    public static void main(String[] args) {
        System.out.println(new Solution().canJump(new int[]{2, 3, 1, 1, 4}));
    }
}
