package Array.Question857;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.stream.IntStream;

public class Solution {
    public double mincostToHireWorkers(int[] quality, int[] wage, int k) {
        int len = quality.length;
        int sumQ = 0;
        Integer[] indexArr = IntStream.range(0, len).boxed().toArray(Integer[]::new);
        //���� ���ʱ�������һ��������һ�ݹ��ʣ���ͬ�¶����θߵ���ߴ�����ͬ��ͬ�ȴ����������±�˳���ɵ����ߣ�����ÿ����������Ҫ����͵�Ա����
        Arrays.sort(indexArr, (a, b) -> quality[b] * wage[a] - quality[a] * wage[b]);
        var pq = new PriorityQueue<Integer>((a, b) -> b - a);
        for (int i = 0; i < k; i++) {
            pq.add(quality[indexArr[i]]);
            sumQ += quality[indexArr[i]];
        }
        // ѡ r ֵ��С�� k ��������ɵ�ǰ�����Ž�
        var ans = sumQ * ((double) wage[indexArr[k - 1]] / quality[indexArr[k - 1]]);
        for (var i = k; i < len; i++) {
            if (quality[indexArr[i]] < pq.peek()) {
                // sumQ ���Ա�С���Ӷ����ܵõ����ŵĴ�
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
