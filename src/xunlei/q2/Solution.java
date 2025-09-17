package xunlei.q2;

import java.util.ArrayList;
import java.util.Objects;

public class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param nums int整型一维数组
     * @param k    int整型
     * @return int整型一维数组
     */
    public int[] find_palindrome_subarrays(int[] nums, int k) {
        // write code here
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int num : nums) {
            list.add(num);
        }
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 0; i + k <= nums.length; i++) {
            if (check(list, i, i + k - 1)) {
                res.add(i);
            }
        }
        int[] ans = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            ans[i] = res.get(i);
        }
        return ans;
    }


    public boolean check(ArrayList<Integer> nums, int start, int end) {
        while (start < end) {
            if (!Objects.equals(nums.get(start), nums.get(end))) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
