package Question349;

import java.util.Arrays;

public class Solution2 {
    public int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int len1 = nums1.length;
        int len2 = nums2.length;
        int[] intersection = new int[len1 + len2];
        int index = 0;
        int index1 = 0;
        int index2 = 0;
        while (index1 < len1 && index2 < len2) {
            if (nums1[index1] == nums2[index2]) {
                //这个index==0可以防止越界
                if (index == 0 || nums1[index1] != intersection[index - 1]) {
                    intersection[index++] = nums1[index1];
                }
                index1++;
                index2++;
            } else if (nums1[index1] < nums2[index2]) {
                index1++;
            } else {
                index2++;
            }
        }
        return Arrays.copyOfRange(intersection, 0, index);
    }
}
