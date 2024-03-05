package Question2917;

public class Solution {
    public int findKOr(int[] nums, int k) {
        int res = 0;
        int[] record = new int[31];
        for (int i = 0; i < 31; i++) {
            for (int j : nums) {
                if (((int) Math.pow(2, i) & j) == (int) Math.pow(2, i)) {
                    record[i]++;
                }
            }
        }
        for (int i = 0; i < record.length; i++) {
            if (record[i] >= k) {
                res += Math.pow(2, i);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2};
        int k = 1;
        Solution solution = new Solution();
        System.out.println(solution.findKOr(nums, k));
    }
}
