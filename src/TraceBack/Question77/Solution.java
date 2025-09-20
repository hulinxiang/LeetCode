package TraceBack.Question77;

import java.util.*;

class Solution {
    int max;
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        this.max = n;
        dfs(n, k, new ArrayList<>());
        return res;
    }

    public void dfs(int curNum, int k, List<Integer> temp) {
        int remain = k - temp.size();
        if (remain == 0) {
            res.add(new ArrayList<>(temp));
            return;
        }

        for (int i = curNum; i >= remain; i--) {
            temp.add(i);
            dfs(i - 1, k, temp);
            temp.remove(temp.size() - 1);
        }

    }


}
