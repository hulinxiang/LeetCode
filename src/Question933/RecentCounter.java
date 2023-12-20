package Question933;

import java.util.*;

/**
 * @author 胡霖翔
 * 知识点：java中的队列是Queue
 * Your RecentCounter object will be instantiated and called as such:
 * RecentCounter obj = new RecentCounter();
 * int param_1 = obj.ping(t);
 */
public class RecentCounter {
    /**
     * 一个value数组，用来保存所有ping的数值，条件是每次数值都越来越大
     */
    Queue<Integer> values;

    public RecentCounter() {
        values = new LinkedList<>();
    }

    public int ping(int t) {
        int left = t - 3000;
        values.add(t);
        int mark = 0;
        while (mark == 0) {
            if (values.element() < left) {
                values.poll();
                continue;
            }
            mark = 1;
        }
        return values.size();
    }

    /**
     * 测试输入：[[],[642],[1849],[4921],[5936],[5957]] 预期结果：[null,1,2,1,2,3]
     */
    public static void main(String[] args) {
        int[] tests = {642, 1849, 4921, 5936, 5957};
        RecentCounter recentCounter1 = new RecentCounter();
        for (int val : tests) {
            System.out.println(recentCounter1.ping(val));
        }
        double f= 8.1;
        System.out.println(f);
    }
}
