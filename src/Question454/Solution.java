package Question454;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 胡霖翔
 * 运用哈希表来进行存储和操作
 * 将数组1和数组2分为一组 数组3和数组4分为另外一组
 */
public class Solution {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        Map<Integer, Integer> count = new HashMap<>();
        //ans 表示符合要求的数量
        int ans = 0;
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                count.put(nums1[i] + nums2[j], count.getOrDefault(nums1[i] + nums2[j], 0) + 1);
            }
        }
        for (int k = 0; k < nums3.length; k++) {
            for (int l = 0; l < nums4.length; l++) {
                if (count.containsKey(-nums3[k] - nums4[l])) {
                    ans += count.get(-nums3[k] - nums4[l]);
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums1 = {-1, -1};
        int[] nums2 = {-1, 1};
        int[] nums3 = {-1, 1};
        int[] nums4 = {1, -1};
        Solution solution = new Solution();
        System.out.println(solution.fourSumCount(nums1, nums2, nums3, nums4));
    }
}
