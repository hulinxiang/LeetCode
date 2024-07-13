package Array.Question189;

import java.util.Arrays;

public class Solution {

    public void rotate(int[] nums, int k) {
        int n = nums.length;
        // 轮转 k 次等于轮转 k%n 次
        k %= n;
        reverse(nums, 0, n - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, n - 1);
    }

    private void reverse(int[] nums, int i, int j) {
        while (i < j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;
            j--;
        }
    }

    public void reverserAll(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        while (low < high) {
            int tmp = nums[low];
            nums[low] = nums[high];
            nums[high] = tmp;
            low++;
            high--;
        }
    }


    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        new Solution().rotate(nums, 3);
        System.out.println(Arrays.toString(nums));
    }

}
