package Question2581;

import java.util.*;

public class Solution {
    private List<Integer>[] g;
    private Set<Long> s = new HashSet<>();
    private int k, ans, cnt0;

    public int rootCount(int[][] edges, int[][] guesses, int k) {
        this.k = k;
        //创建地图g
        g = new ArrayList[edges.length + 1];
        Arrays.setAll(g, o -> new ArrayList<>());
        for (int[] e : edges) {
            int x = e[0];
            int y = e[1];
            g[x].add(y);
            g[y].add(x);
        }

        //非常牛逼的位操作,压缩空间
        for (int[] e : guesses) {
            s.add((long) e[0] << 32 | e[1]);
        }
        dfs(0, -1);
        reroot(0, -1, cnt0);
        return ans;
    }


    /**
     * 一开始用dfs算法来对根节点进行一个最初的遍历
     *
     * @param x  x代表当前节点
     * @param fa 代表x的前序节点
     */
    private void dfs(int x, int fa) {
        for (int y : g[x]) {
            if (y != fa) {
                //说明有一条边猜对了
                if (s.contains((long) x << 32 | y)) {
                    cnt0++;
                }
                dfs(y, x);
            }
        }
    }

    /**
     * 本题的核心：换根算法
     * ==========================
     *
     * @param x   代表以当前的节点为根节点
     * @param fa  x的前序节点
     * @param cnt 猜对次数
     */
    private void reroot(int x, int fa, int cnt) {
        if (cnt >= k) {
            ans++;
        }
        for (int y : g[x]) {
            if (y != fa) {
                int c = cnt;
                if (s.contains((long) x << 32 | y)) {
                    c--;
                    //说明原先是对的所以要减去1
                }
                if (s.contains((long) y << 32 | x)) {
                    c++;
                    //说明原先是错的所以要加上1
                }
                reroot(y, x, c);
            }
        }
    }


}
