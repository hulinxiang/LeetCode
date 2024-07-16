package Array.Question134;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * dfs,��ʱ��
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
            // ˵�����ֻʣ��curGas�����͵���index���λ�ã�һ����ʧ��
            arrayLists[index].add(curGas);
            return false;
        }
        // ͬ��
        if (arrayLists[index].contains(curGas)) {
            return false;
        }
        // �����п��ܲ�ʧ�ܣ����Խ�������
        if (index == indexToReach && mark == 1) {
            return true;
        }
        if (index == indexToReach && mark == 0) {
            mark = 1;
        }
        return dfs(gas, cost, (index + 1) % n, curGas + gas[index] - cost[index]);
    }


}
