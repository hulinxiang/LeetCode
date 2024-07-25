package Matrix.Question54;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> order = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return order;
        }

        int left = 0;
        int right = matrix[0].length - 1;
        int top = 0;
        int bottom = matrix.length - 1;
        while (left <= right && top <= bottom) {
            // 添加最上面的一行元素
            for (int column = left; column <= right; column++) {
                order.add(matrix[top][column]);
            }
            // 添加最右边的一行元素
            for (int row = top + 1; row <= bottom; row++) {
                order.add(matrix[row][right]);
            }
            if (bottom > top && right > left) {
                for (int column = right - 1; column >= left; column--) {
                    order.add(matrix[bottom][column]);
                }
                for (int row = bottom - 1; row > top; row--) {
                    order.add(matrix[row][left]);
                }
            }

            left++;
            right--;
            top++;
            bottom--;

        }
        return order;
    }

    public static void main(String[] args) {
        int[][] ints = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        System.out.println(new Solution().spiralOrder(ints));
    }
}
