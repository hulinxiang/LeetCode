package Question2867;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Hu
 */
public class Solution {
    //首先通过埃氏筛来判断一个数字是不是质数
    private static final int N = 100001;
    private static boolean[] isPrime = new boolean[N];

    //因为属性是静态的,所以要访问到它必须在静态块中进行访问
    static {
        Arrays.fill(isPrime, true);
        //0,1不是质数
        isPrime[0] = false;
        isPrime[1] = false;
        for (int i = 2; i < N; i++) {
            //如果i是质数才进行以下操作
            if (isPrime[i]) {
                //把能够被i整除的所有j都置为false
                for (int j = 2 * i; j < N; j += i) {
                    isPrime[j] = false;
                }
            }
        }
    }

    public long countPaths(int n, int[][] edges) {
        //因为只有边的相关信息,故先要根据边来构建树的邻接表
        List<Integer>[] list = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) {
            list[i] = new ArrayList<>();
        }

        //初始化邻接表,因为是无向树,故而每个边被统计了两次
        for (int[] e : edges) {
            int i = e[0];
            int j = e[1];
            list[i].add(j);
            list[j].add(i);
        }

        //保存已经访问过的节点
        List<Integer> visited = new ArrayList<>();
        long res = 0;
        long[] count = new long[n + 1];
        //因为有n个节点且节点编号为1到n
        for (int i = 1; i <= n; i++) {
            //要求i是质数
            if (!isPrime[i]) {
                continue;
            }
            long cur = 0;
            for (int j : list[i]) {
                //要求j不是质数,因为i已经是质数了,不能再有一个质数
                if (isPrime[j]) {
                    continue;
                }
                if (count[j] == 0) {
                    visited.clear();
                    dfs(list, visited, j, 0);
                    //cnt表示通过j(j不是质数),j能够到达非质数的节点的个数
                    long cnt = visited.size();
                    for (int k : visited) {
                        count[k] = cnt;
                    }
                }
                res += count[j] * cur;
                cur += count[j];
            }
            res += cur;
        }
        return res;
    }

    private void dfs(List<Integer>[] G, List<Integer> visited, int i, int pre) {
        visited.add(i);
        for (int j : G[i]) {
            if (j != pre && !isPrime[j]) {
                dfs(G, visited, j, i);
            }
        }
    }


    public static void main(String[] args) {
        int[][] edgs = {{1, 2}, {1, 3}, {2, 4}, {2, 5}};
        int n = 5;
        Solution solution = new Solution();
        System.out.println(solution.countPaths(n, edgs));

    }
}
