package BinarySearch.Question4;


/**
 * @author Linxiang Hu
 */
public class Solution1 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] res = new int[nums1.length + nums2.length];
        int i = 0;
        int j = 0;
        int index = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j]) {
                res[index++] = nums1[i++];
            } else {
                res[index++] = nums2[j++];
            }
        }
        //说明数组1还有剩余
        if (i < nums1.length) {
            while (i < nums1.length) {
                res[index++] = nums1[i++];
            }
        }
        //说明数组2还有剩余
        if (j < nums2.length) {
            while (j < nums2.length) {
                res[index++] = nums2[j++];
            }
        }
        int ans = nums1.length + nums2.length;
        if (ans % 2 == 0) {
            double double1 = res[ans / 2];
            double double2 = res[ans / 2 - 1];
            return (double1 + double2) / 2;
        }
        return res[ans / 2];
    }
}
