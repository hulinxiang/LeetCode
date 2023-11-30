package Question349;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 题目描述：给定两个数组 nums1 和 nums2 ，返回 它们的交集 。输出结果中的每个元素一定是 唯一 的。我们可以 不考虑输出结果的顺序 。
 * 暴力解法
 *
 * @author 胡霖翔
 */
public class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        int[] news1 = deleteRedundant(nums1);
        int[] news2 = deleteRedundant(nums2);
        int[] res = new int[1001];
        Arrays.fill(res, -1);
        for (int val : news1) {
            res[val]++;
        }
        for (int val : news2) {
            res[val]++;
        }
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = 0; i < res.length; i++) {
            if (res[i] == 1) {
                ans.add(i);
            }
        }
        int[] ans1 = new int[ans.size()];
        int mark = 0;
        for (int val : ans) {
            ans1[mark] = val;
            mark++;
        }
        return ans1;

    }


    public static int[] deleteRedundant(int[] num) {
        int[] save = new int[1001];
        for (int val : num) {
            save[val]++;
        }
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 0; i < save.length; i++) {
            if (save[i] != 0) {
                res.add(i);
            }
        }
        int[] ans = new int[res.size()];
        int mark = 0;
        for (int val : res) {
            ans[mark] = val;
            mark++;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] num1 = new int[]{1, 2, 2, 1};
        int[] num2 = new int[]{2, 2};
        System.out.println(Arrays.toString(new Solution().intersection(num1, num2)));
    }
}