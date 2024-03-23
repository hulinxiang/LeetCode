package Question2617;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {
    public int minimumVisitedCells(int[][] grid) {
        //m:行数 n:列数
        int m = grid.length;
        int n = grid[0].length;
        int f = 0;
        PriorityQueue<int[]>[] colHeaps = new PriorityQueue[n];
        //colHeaps 即为每一列的最小堆，其中优先队列里面放的是数组，数组中第一个元素代表到这一列的跳数，数组中第二个元素代表g+i
        Arrays.setAll(colHeaps, i -> new PriorityQueue<int[]>(Comparator.comparingInt(a -> a[0])));
        PriorityQueue<int[]> rowH = new PriorityQueue<>((a, b) -> (a[0] - b[0]));
        for (int i = 0; i < m; i++) {
            rowH.clear();
            for (int j = 0; j < n; j++) {
                //无法到达第j列
                while (!rowH.isEmpty() && rowH.peek()[1] < j) {
                    rowH.poll();
                }
                PriorityQueue<int[]> colH = colHeaps[j];
                //无法到达第i行
                while (!colH.isEmpty() && colH.peek()[1] < i) {
                    colH.poll();
                }

                f = i > 0 || j > 0 ? Integer.MAX_VALUE : 1;
                if (!rowH.isEmpty()) {
                    //从左边跳过来
                    f = rowH.peek()[0] + 1;
                }
                if (!colH.isEmpty()) {
                    //从上边跳过来
                    f = Math.min(f, colH.peek()[0] + 1);
                }

                int g = grid[i][j];
                if (g > 0 && f < Integer.MAX_VALUE) {
                    rowH.offer(new int[]{f, g + j});// 经过的格子数，向右最远能到达的列号
                    colH.offer(new int[]{f, g + i}); // 经过的格子数，向下最远能到达的行号
                }
            }
        }

        return f < Integer.MAX_VALUE ? f : -1; // 此时的 f 是在 (m-1, n-1) 处算出来的
    }


}
