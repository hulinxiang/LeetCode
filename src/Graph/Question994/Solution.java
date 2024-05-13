package Graph.Question994;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    private final int[][] DIRECTIONS = new int[][]{{-1, 0}, {1, 0}, {0, 1}, {0, -1}};


    public int orangesRotting(int[][] grid) {
        List<int[]> badOrange = new ArrayList<>();
        int m = grid.length;
        int n = grid[0].length;
        int fresh = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    fresh++;
                }
                if (grid[i][j] == 2) {
                    badOrange.add(new int[]{i, j});
                }
            }
        }


        int ans = -1;
        while (!badOrange.isEmpty()) {
            ans++;
            List<int[]> tmp = badOrange;
            badOrange = new ArrayList<>();
            for (int[] arr : tmp) {
                for (int[] d : DIRECTIONS) {
                    int i = arr[0] + d[0];
                    int j = arr[1] + d[1];
                    if (0 <= i && i < m && 0 <= j && j < n && grid[i][j] == 1) {
                        badOrange.add(new int[]{i, j});
                        fresh--;
                        grid[i][j] = 2;
                    }
                }
            }
        }

        return fresh > 0 ? -1 : Math.max(ans, 0);
    }

}
