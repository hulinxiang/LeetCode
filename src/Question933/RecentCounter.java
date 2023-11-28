package Question933;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author 胡霖翔
 * Your RecentCounter object will be instantiated and called as such:
 * RecentCounter obj = new RecentCounter();
 * int param_1 = obj.ping(t);
 */
public class RecentCounter {
    /**
     * 一个value数组，用来保存所有ping的数值，条件是每次数值都越来越大
     */
    ArrayList<Integer> values = new ArrayList<>();

    public RecentCounter() {

    }

    public int ping(int t) {
        values.add(t);
        int left = t - 3000;
        int right = t;
        int num = 0;
        for (Integer integer : values) {
            if (integer >= left && integer <= right) {
                num++;
            }
        }
        return num;
    }
}
