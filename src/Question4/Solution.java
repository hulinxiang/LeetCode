package Question4;


/**
 * Binary search
 * 定义分割线右边比分割线左边多一个元素
 * 分割线定义：分割线的位置就是分割线左边数组元素的个数，比如分割线位置为3，那么分割线左边有三个元素0,1,2
 */
class Solution {
//    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
//        int len1 = nums1.length;
//        int len2 = nums2.length;
//        //让数组1的长度严格小于数组2的长度
//        if (len1 > len2) {
//            return findMedianSortedArrays(nums2, nums1);
//        }
//        //定义了分割线左边元素应该有的个数
//        int totalLeft = (len1 + len2) / 2;
//
//        //在数组nums1中间寻找合适的分割线位置(使用二分查找,左闭右开)
//        int left = 0;
//        int right = len1;
//        while (left < right) {
//            //i 代表的是第一个数组中的位置
//            int i = (left + right) / 2;
//            //j 代表的是第二个数组中的位置，我们只需要更新第一个数组中的分割线位置，
//            //第二个数组中的分割线位置可以通过总数减去第一个数组的分割线位置来进行计算
//            int j = totalLeft - i;
//            //说明分割线不符合要求，还需要继续迭代
//            if (nums1[i - 1] > nums2[j]) {
//                right = i;
//            } else if (nums2[j - 1] > nums1[i]) {
//                left = i;
//            }
//            //最后退出循环的时候left==right,说明找到了数组1中的正确位置
//        }
//        //如果总长度是偶数
//        if((len1+len2)%2==0){
//
//        }
//    }
}