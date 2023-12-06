package Question349;

import java.util.HashSet;
import java.util.Set;

/**
 * @author 胡霖翔
 * 如果使用哈希集合存储元素，则可以在 O(1)O(1)O(1) 的时间内判断一个元素是否在集合中，从而降低时间复杂度。
 */
class Solution1 {
    public int[] intersection(int[] nums1, int[] nums2) {
        //set1 存放第一个数组的元素
        //set2 存放第二个数组的元素
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        for (int i : nums1) {
            set1.add(i);
        }
        for (int j : nums2) {
            set2.add(j);
        }

        return getIntersection(set1, set2);
    }

    public int[] getIntersection(Set<Integer> set1, Set<Integer> set2) {
        //确保set1的大小一定是小于set2的大小的
        if (set1.size() > set2.size()) {
            return getIntersection(set2, set1);
        }
        Set<Integer> intersection = new HashSet<>();
        for (int i : set1) {
            if (set2.contains(i)) {
                intersection.add(i);
            }
        }
        int[] res = new int[intersection.size()];
        int index = 0;
        for (int i : intersection) {
            res[index++] = i;
        }
        return res;

    }


}

