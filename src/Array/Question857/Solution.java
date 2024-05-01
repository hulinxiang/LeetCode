package Array.Question857;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.stream.IntStream;

public class Solution {
    public double mincostToHireWorkers(int[] quality, int[] wage, int k) {
        int len = quality.length;
        int sumQ = 0;
        Integer[] indexArr = IntStream.range(0, len).boxed().toArray(Integer[]::new);
        //定义 工资比质量，一份质量给一份工资，故同事都被拔高到最高待遇的同事同等待遇。排序下标顺序由低至高，先找每份质量工质要求最低的员工。
        Arrays.sort(indexArr, (a, b) -> quality[b] * wage[a] - quality[a] * wage[b]);
        var pq = new PriorityQueue<Integer>((a, b) -> b - a);
        for (int i = 0; i < k; i++) {
            pq.add(quality[indexArr[i]]);
            sumQ += quality[indexArr[i]];
        }
        // 选 r 值最小的 k 名工人组成当前的最优解
        var ans = sumQ * ((double) wage[indexArr[k - 1]] / quality[indexArr[k - 1]]);
        for (var i = k; i < len; i++) {
            if (quality[indexArr[i]] < pq.peek()) {
                // sumQ 可以变小，从而可能得到更优的答案
                sumQ -= pq.poll();
                sumQ += quality[indexArr[i]];
                pq.add(quality[indexArr[i]]);
                var cur = (double) wage[indexArr[i]] / quality[indexArr[i]];
                ans = Math.min(ans, sumQ * cur);
            }

        }
        return ans;
    }
}
