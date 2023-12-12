package Question88;

import java.util.Arrays;

public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int index = m + n - 1;
        int i = m - 1;
        int j = n - 1;
        while (index >= 0) {
            if (j == -1) {
                break;
            }
            if (i == -1) {
                System.arraycopy(nums2, 0, nums1, 0, j+1);
                break;
            }
            if (nums1[i] > nums2[j]) {
                nums1[index--] = nums1[i];
                i--;
            } else {
                nums1[index--] = nums2[j];
                j--;
            }
        }
    }

    public static void main(String[] args) {
        int[] a = new int[]{7, 7, 7, 0, 0, 0};
        int[] b = new int[]{4, 5, 6};
        int m = 3;
        int n = 3;
        Solution solution = new Solution();
        solution.merge(a, m, b, n);
        System.out.println(Arrays.toString(a));
    }
}
