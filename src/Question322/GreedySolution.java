package Question322;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * ����̰���㷨��⣬�߼��Ѿ�û�����ˣ����Ǳ��ⲻ̫�ʺ�̰���㷨����Ȼ�����Ż������ǻ��Ǹ��ʺ��ö�̬�滮���
 *
 * @author Hu
 */
public class GreedySolution {
    public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        int sum = 0;
        int[] records = new int[coins.length];
        while (sum < amount) {
            sum += coins[coins.length - 1];
            records[coins.length - 1]++;
        }
        if (sum == amount) {
            return Arrays.stream(records).sum();
        }
        boolean[] ifFind = new boolean[1];
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((a, b) -> Arrays.stream(a).sum() - Arrays.stream(b).sum());
        coinNumber(coins, coins.length - 1, amount, records, sum, ifFind, priorityQueue);
        if (!ifFind[0]) {
            return -1;
        }
        return Arrays.stream(priorityQueue.poll()).sum();
    }

    /**
     * ��̰���㷨�����Բ��ϵؼ����������Ľ��
     */
    public void coinNumber(int[] coins, int curIndex, int amount, int[] records, int sum, boolean[] ifFind, PriorityQueue<int[]> priorityQueue) {
        //ע��Ĭ�Ͻ���ݹ��ʱ��sum��ֵ�Ǵ��ڵ�����amount��
        if (sum == amount || curIndex == 0) {
            return;
        }
        while (records[curIndex] > 0) {
            //������ݹ�Ļ���
            if (records[0] != 0) {
                records[0] = 0;
            }
            records[curIndex]--;
            sum = calculate(coins, records);
            while (sum < amount) {
                sum += coins[curIndex - 1];
                records[curIndex - 1]++;
            }
            if (sum == amount) {
                ifFind[0] = true;
                int[] recordsCopy = Arrays.copyOf(records, records.length);
                priorityQueue.add(recordsCopy);
            }
            coinNumber(coins, curIndex - 1, amount, records, sum, ifFind, priorityQueue);
        }

    }

    private int calculate(int[] coins, int[] records) {
        int ans = 0;
        for (int i = 0; i < records.length; i++) {
            if (records[i] != 0) {
                ans += records[i] * coins[i];
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] coins = {3, 7, 405, 436};
        int amount = 8839;
        System.out.println(new GreedySolution().coinChange(coins, amount));
    }

}
