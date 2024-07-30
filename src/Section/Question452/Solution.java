package Section.Question452;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {
    public int findMinArrowShots(int[][] points) {
        if (points.length == 0) {
            return 0;
        }

        // 按气球的结束坐标对气球进行排序
        Arrays.sort(points, Comparator.comparingInt(a -> a[1]));

        int arrows = 1;
        int currentEnd = points[0][1];

        for (int[] point : points) {
            if (point[0] > currentEnd) {
                arrows++;
                currentEnd = point[1];
            }
        }

        return arrows;
    }
}
