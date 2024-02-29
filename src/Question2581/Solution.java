package Question2581;

import java.util.*;

public class Solution {
    private List<Integer>[] g;
    private Set<Long> s = new HashSet<>();
    private int k, ans, cnt0;

    public int rootCount(int[][] edges, int[][] guesses, int k) {
        this.k = k;
        //������ͼg
        g = new ArrayList[edges.length + 1];
        Arrays.setAll(g, o -> new ArrayList<>());
        for (int[] e : edges) {
            int x = e[0];
            int y = e[1];
            g[x].add(y);
            g[y].add(x);
        }

        //�ǳ�ţ�Ƶ�λ����,ѹ���ռ�
        for (int[] e : guesses) {
            s.add((long) e[0] << 32 | e[1]);
        }
        dfs(0, -1);
        reroot(0, -1, cnt0);
        return ans;
    }


    /**
     * һ��ʼ��dfs�㷨���Ը��ڵ����һ������ı���
     *
     * @param x  x����ǰ�ڵ�
     * @param fa ����x��ǰ��ڵ�
     */
    private void dfs(int x, int fa) {
        for (int y : g[x]) {
            if (y != fa) {
                //˵����һ���߲¶���
                if (s.contains((long) x << 32 | y)) {
                    cnt0++;
                }
                dfs(y, x);
            }
        }
    }

    /**
     * ����ĺ��ģ������㷨
     * ==========================
     *
     * @param x   �����Ե�ǰ�Ľڵ�Ϊ���ڵ�
     * @param fa  x��ǰ��ڵ�
     * @param cnt �¶Դ���
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
                    //˵��ԭ���ǶԵ�����Ҫ��ȥ1
                }
                if (s.contains((long) y << 32 | x)) {
                    c++;
                    //˵��ԭ���Ǵ������Ҫ����1
                }
                reroot(y, x, c);
            }
        }
    }


}
