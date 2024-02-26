package Question713;

/**
 * @author 胡霖翔
 */
public class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int n = nums.length;
        int ans = 0;
        int cur = 1;
        //j 表示滑动窗口的左端; i 表示滑动窗口的右端
        int j = 0;
        //将元素累积相乘计算当前的累乘值
        for (int i = 0; i < n; i++) {
            cur *= nums[i];
            while (j <= i && cur >= k) {
                cur /= nums[j];
                j++;
            }
            //这一步是滑动窗口的核心
            //  nums[right]
            //  nums[right-1], nums[right]
            //  nums[right-2], nums[right-1], nums[right]
            //  nums[left], ......, nums[right-2], nums[right-1], nums[right]
            //共有 right - left + 1 种
            //相当于只有在每次右指针向右移动变化时,才会更新新增加的组合数量
            ans += i - j + 1;
        }
        return ans;
    }
}
