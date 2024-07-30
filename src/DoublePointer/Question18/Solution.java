package DoublePointer.Question18;

import java.util.*;

/**
 * @author 胡霖翔
 * Recursion 涉及到剪枝的操作，同时还涉及到int和long的表示范围
 */
public class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        //对数组进行一个初始的排序(从小到大的顺序)
        Arrays.sort(nums);
        boolean[] used = new boolean[nums.length];
        List<Integer> current = new ArrayList<>();
        int cur = 0;
        List<List<Integer>> ans = new ArrayList<>();
        findFourSum(used, ans, current, nums, target, cur, 0);
        return ans;
    }

    public static void findFourSum(boolean[] used, List<List<Integer>> ans, List<Integer> current, int[] nums, int target, int cur, int start) {
        if (current.size() == 4 && cur == target) {
            for (List<Integer> list : ans) {
                if (ifSame(list, current)) {
                    return;
                }
            }
            List<Integer> list = new ArrayList<>(current);
            ans.add(list);
        } else {
            for (int i = start; i < nums.length; i++) {
                //说明已经不符合条件了，直接剪枝
                //剪枝，避免不可能达到目标值的分支
                if (cur + (long) (4 - current.size()) * nums[nums.length - 1] < target) {
                    return;
                }
                if (cur + (long) (4 - current.size()) * nums[i] > target) {
                    return;
                }
                //说明长度已经不可能足够了
                if (4 - current.size() > nums.length - i) {
                    return;
                }
                //代表已经用过
                if (used[i]) {
                    continue;
                }
                used[i] = true;
                cur += nums[i];
                current.add(nums[i]);
                findFourSum(used, ans, current, nums, target, cur, start + 1);
                cur -= nums[i];
                current.remove(current.size() - 1);
                used[i] = false;
                while (i + 1 < nums.length) {
                    if (nums[i + 1] == nums[i]) {
                        i++;
                    } else {
                        break;
                    }
                }
            }
        }
    }

    public static boolean ifSame(List<Integer> oldL1, List<Integer> oldL2) {
        HashMap<Integer, Integer> hashMap = new HashMap<>(oldL1.size());
        for (Integer integer : oldL1) {
            if (!hashMap.containsKey(integer)) {
                hashMap.put(integer, 1);
            } else {
                int val = hashMap.get(integer);
                hashMap.replace(integer, val + 1);
            }
        }
        for (Integer integer : oldL2) {
            if (!hashMap.containsKey(integer)) {
                return false;
            } else {
                int val = hashMap.get(integer);
                if (val == 0) {
                    return false;
                }
                hashMap.replace(integer, val - 1);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        long timer = System.currentTimeMillis();
        int[] nums = {2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2};
        int target = 8;
        Solution solution = new Solution();
        System.out.println(solution.fourSum(nums, target));
        long t2 = System.currentTimeMillis();
        System.out.println(t2 - timer);
    }
}
