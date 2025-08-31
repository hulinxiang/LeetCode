package pdd.Q1;

import java.util.*;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt(); // 多少组测试用例

        StringBuilder res = new StringBuilder();
        while (T-- > 0) {
            long H = in.nextLong(); // 可工作时长的区间, [1,H]
            int N = in.nextInt(); // 预警区间的个数
            Map<Long, Long> map = new TreeMap<>();
            for (int i = 0; i < N; i++) {
                long x = in.nextLong();
                long y = in.nextLong();
                long l = Math.min(1, x);
                long r = Math.max(y, H);
                map.put(l, r);
            }
            long newStart = map.keySet().iterator().next();
            long newEnd = map.get(newStart);
            long overlap = 0;
            for (int i = 1; i < map.size(); i++) {
                Map.Entry<Long, Long> entry = Main.getEntry(i, map);
                long x = entry.getKey();
                long y = entry.getValue();
                if (x <= newEnd + 1) {
                    newEnd = Math.max(newEnd, y);
                } else {
                    overlap += (newEnd - newStart + 1);
                    newStart = x;
                    newEnd = y;
                }
            }
            overlap += newEnd - newStart + 1;
            long workTime = H - overlap;
            workTime = Math.max(workTime, 0);
            res.append(workTime).append("\n");
        }
        System.out.println(res);
    }

    private static Map.Entry<Long, Long> getEntry(int i, Map<Long, Long> map) {
        int idx = 0;
        for (Map.Entry<Long, Long> entry : map.entrySet()) {
            if (idx == i) {
                return entry;
            }
            idx++;
        }
        return null;
    }
}
