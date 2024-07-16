package Array.Question134;

public class Solution1 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int curSum = 0;
        int totalSum = 0;
        int start = 0;
        for (int i = 0; i < gas.length; i++) {
            curSum += gas[i] - cost[i];
            totalSum += gas[i] - cost[i];
            if (curSum < 0) {
                // 当前累加rest[i]和 curSum一旦小于0
                start = i + 1;
                // 起始位置更新为i+1
                curSum = 0;
                // curSum从0开始
            }
        }
        if (totalSum < 0) {
            return -1;
            // 说明怎么走都不可能跑一圈了
        }
        return start;
    }
}
