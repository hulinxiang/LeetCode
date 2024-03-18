package Question1973;

class Solution {

    /**
     * 双指针加贪心
     * 注意：贪心每次只能贪一步，贪多了就出错了。
     */
    public int maximumScore(int[] nums, int k) {
        int left = k;
        int right = k;
        int len = nums.length;
        int curMin = nums[k];
        int ans = nums[k];
        while (true) {
            while (right <= len - 2 && nums[right + 1] >= curMin) {
                right++;
            }
            while (left >= 1 && nums[left - 1] >= curMin) {
                left--;
            }
            ans = Math.max(ans, curMin * (right - left + 1));
            if (right == len - 1 && left == 0) {
                break;
            }
            if (right != len - 1 && left != 0) {
                curMin = Math.max(nums[left - 1], nums[right + 1]);
            }
            if (right == len - 1 && left != 0) {
                curMin = nums[--left];
            }
            if (right != len - 1 && left == 0) {
                curMin = nums[++right];
            }

        }
        return ans;
    }


    public static void main(String[] args) {
        int[] n = {1, 4, 3, 7, 4, 5};
        int k = 3;
        System.out.println(new Solution().maximumScore(n, k));
    }

}
