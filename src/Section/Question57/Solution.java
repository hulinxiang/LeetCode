package Section.Question57;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> ans = new ArrayList<>();
        int left = newInterval[0];
        int right = newInterval[1];
        int mark = 0;
        for (int[] ints : intervals) {
            int curRight = ints[1];
            int curLeft = ints[0];
            // 不能合并的时候
            if (left > curRight || right < curLeft) {
                if (mark == 0) {
                    ans.add(ints);
                } else {
                    ans.add(new int[]{left, right});
                    left = curLeft;
                    right = curRight;
                }
            } else {
                left = Math.min(left, curLeft);
                right = Math.max(right, curRight);
                mark++;
            }
        }
        ans.add(new int[]{left, right});
        int[][] res = ans.toArray(new int[ans.size()][]);
        Arrays.sort(res, (a, b) -> a[0] > b[0] ? 1 : a[0] == b[0] ? 0 : -1);
        return res;

    }

    public static void main(String[] args) {
        int[][] intervals = {{1, 3}, {6, 9}};
        int[] newIntervals = {2, 5};
        System.out.println(Arrays.deepToString(new Solution().insert(intervals, newIntervals)));
    }
}
