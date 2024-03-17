package Question310;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


/**
 * https://blog.csdn.net/weq2011/article/details/135991449
 * 换根dp,只用遍历一遍,时间复杂度为O(n)
 * 传统dp,时间复杂度为O(1)
 * https://zhuanlan.zhihu.com/p/348349531
 * <p>
 * dh[x] = dh[fa] - siz[x] + (n - siz[x])
 */
public class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        //构建邻接矩阵
        List<Integer>[] matrix = new ArrayList[n];
        int[] degrees = new int[n];
        for (int i = 0; i < n; i++) {
            matrix[i] = new ArrayList<>();
        }
        for (int[] pairs : edges) {
            matrix[pairs[0]].add(pairs[1]);
            matrix[pairs[1]].add(pairs[0]);
            degrees[pairs[0]]++;
            degrees[pairs[1]]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (degrees[i] == 1) {
                queue.add(i);
            }
        }

        while (n > 2) {
            n -= queue.size();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int cur = queue.poll();
                for (int j = 0; j < matrix[cur].size(); j++) {
                    if (--degrees[matrix[cur].get(j)] == 1) {
                        queue.add(matrix[cur].get(j));
                    }
                }
            }
        }

        return new ArrayList<>(queue);
    }


    public static void main(String[] args) {
        int[][] grid = {
                {3, 0},
                {3, 1},
                {3, 2},
                {3, 4},
                {5, 4}
        };
        int n = 6;
        System.out.println(new Solution().findMinHeightTrees(n, grid));
    }


}
