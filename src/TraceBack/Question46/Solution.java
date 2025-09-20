package TraceBack.Question46;

import java.util.*;

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            list.add(num);
        }
        dfs(list, 0, res);
        return res;
    }

    public void dfs(List<Integer> list, int indexToFix, List<List<Integer>> res) {
        if (indexToFix == list.size()) {
            res.add(new ArrayList<>(list));
            return;
        }

        for (int i = indexToFix; i < list.size(); i++) {
            Collections.swap(list, i, indexToFix);
            dfs(list, indexToFix + 1, res);
            Collections.swap(list, i, indexToFix);

        }
    }
}
