package Array.Question134;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * dfs,超时了
 */
public class Solution {
    int idx = -1;
    ArrayList<Integer>[] arrayLists;
    int indexToReach;
    int mark;
    int n;

    public int canCompleteCircuit(int[] gas, int[] cost) {
        n = gas.length;
        arrayLists = new ArrayList[n];
        Arrays.setAll(arrayLists, i -> new ArrayList<>());
        for (int i = 0; i < n; i++) {
            mark = 0;
            indexToReach = i;
            if (dfs(gas, cost, i, 0)) {
                return i;
            }
        }
        return -1;
    }

    public boolean dfs(int[] gas, int[] cost, int index, int curGas) {
        if (curGas + gas[index] < cost[index]) {
            // 说明如果只剩下curGas升的油到了index这个位置，一定会失败
            arrayLists[index].add(curGas);
            return false;
        }
        // 同理
        if (arrayLists[index].contains(curGas)) {
            return false;
        }
        // 现在有可能不失败，所以进行讨论
        if (index == indexToReach && mark == 1) {
            return true;
        }
        if (index == indexToReach && mark == 0) {
            mark = 1;
        }
        return dfs(gas, cost, (index + 1) % n, curGas + gas[index] - cost[index]);
    }


}
