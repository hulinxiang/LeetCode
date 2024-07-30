package Section.Question56;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(p -> p[0]));
        List<int[]> list = new ArrayList<>();
        int left = intervals[0][0];
        int right = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            int curLeft = intervals[i][0];
            int curRight = intervals[i][1];
            if (curLeft <= right) {
                right = Math.max(right, curRight);
            } else {
                // 说明遇到了新的一个区间
                list.add(new int[]{left, right});
                left = curLeft;
                right = curRight;
            }
        }
        list.add(new int[]{left, right});
        return list.toArray(new int[list.size()][]);
    }
}
