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
                // ��ǰ�ۼ�rest[i]�� curSumһ��С��0
                start = i + 1;
                // ��ʼλ�ø���Ϊi+1
                curSum = 0;
                // curSum��0��ʼ
            }
        }
        if (totalSum < 0) {
            return -1;
            // ˵����ô�߶���������һȦ��
        }
        return start;
    }
}
