package Array.Question2923;

public class Solution {

    public int findChampion(int[][] grid) {
        int n = grid.length;
        for (int i = 0; i < grid.length; i++) {
            int sum = 0;
            for (int j = 0; j < grid[i].length; j++) {
                sum += grid[i][j];
            }
            if (sum == n - 1) {
                return i;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int[][] grid = new int[2][2];
        grid[0] = new int[]{0, 1};
        grid[1] = new int[]{0, 0};
        System.out.println(new Solution().findChampion(grid));
    }
}
