package Question2867;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Hu
 */
public class Solution {
    //����ͨ������ɸ���ж�һ�������ǲ�������
    private static final int N = 100001;
    private static boolean[] isPrime = new boolean[N];

    //��Ϊ�����Ǿ�̬��,����Ҫ���ʵ��������ھ�̬���н��з���
    static {
        Arrays.fill(isPrime, true);
        //0,1��������
        isPrime[0] = false;
        isPrime[1] = false;
        for (int i = 2; i < N; i++) {
            //���i�������Ž������²���
            if (isPrime[i]) {
                //���ܹ���i����������j����Ϊfalse
                for (int j = 2 * i; j < N; j += i) {
                    isPrime[j] = false;
                }
            }
        }
    }

    public long countPaths(int n, int[][] edges) {
        //��Ϊֻ�бߵ������Ϣ,����Ҫ���ݱ������������ڽӱ�
        List<Integer>[] list = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) {
            list[i] = new ArrayList<>();
        }

        //��ʼ���ڽӱ�,��Ϊ��������,�ʶ�ÿ���߱�ͳ��������
        for (int[] e : edges) {
            int i = e[0];
            int j = e[1];
            list[i].add(j);
            list[j].add(i);
        }

        //�����Ѿ����ʹ��Ľڵ�
        List<Integer> visited = new ArrayList<>();
        long res = 0;
        long[] count = new long[n + 1];
        //��Ϊ��n���ڵ��ҽڵ���Ϊ1��n
        for (int i = 1; i <= n; i++) {
            //Ҫ��i������
            if (!isPrime[i]) {
                continue;
            }
            long cur = 0;
            for (int j : list[i]) {
                //Ҫ��j��������,��Ϊi�Ѿ���������,��������һ������
                if (isPrime[j]) {
                    continue;
                }
                if (count[j] == 0) {
                    visited.clear();
                    dfs(list, visited, j, 0);
                    //cnt��ʾͨ��j(j��������),j�ܹ�����������Ľڵ�ĸ���
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
