package Question2684;

import java.util.Arrays;

public class Solution {
    public int maxMoves(int[][] grid) {
        int m = grid.length - 1;
        int n = grid[0].length - 1;
        int[][] memo = new int[m + 1][n + 1];
        int max = 0;
        for (int[] me : memo) {
            Arrays.fill(me, -1);
        }
        for (int i = 0; i <= m; i++) {
            int cur = dfs(grid, i, 0, m, n, 0, memo);
            max = Math.max(cur, max);
        }
        return max;
    }

    //�����ƶ��� (row - 1, col + 1)��(row, col + 1) ��
    //(row + 1, col + 1)������Ԫ������һ����ֵ
    //�ϸ���ڵ�ǰ��Ԫ��ĵ�Ԫ��
    //m �� n ���±꣬���ǳ���
    public int dfs(int[][] grid, int i, int j, int m, int n, int sum, int[][] memo) {
        if (memo[i][j] != -1) {
            return memo[i][j];
        }
        //˵���ƶ����߽���
        if (j >= n) {
            return sum;
        }
        int op1 = 0, op2 = 0, op3 = 0;
        if (i > 0 && grid[i][j] < grid[i - 1][j + 1]) {
            op1 = dfs(grid, i - 1, j + 1, m, n, sum + 1, memo);
        }
        if (grid[i][j] < grid[i][j + 1]) {
            op2 = dfs(grid, i, j + 1, m, n, sum + 1, memo);
        }
        if (i != m && grid[i][j] < grid[i + 1][j + 1]) {
            op3 = dfs(grid, i + 1, j + 1, m, n, sum + 1, memo);
        }
        int max = Math.max(Math.max(Math.max(op1, op2), op3), sum);
        memo[i][j] = max;
        return max;
    }

    public static void main(String[] args) {
        int[][] array = {
                {187, 167, 209, 251, 152, 236, 263, 128, 135},
                {267, 249, 251, 285, 73, 204, 70, 207, 74},
                {189, 159, 235, 66, 84, 89, 153, 111, 189},
                {120, 81, 210, 7, 2, 231, 92, 128, 218},
                {193, 131, 244, 293, 284, 175, 226, 205, 245}
        };
        System.out.println(new Solution().maxMoves(array));
    }
}
