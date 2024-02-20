package Question239;

import java.util.Comparator;
import java.util.PriorityQueue;


/**
 * 测试大根堆的实现
 */
public class PriorityQueueTest {


    public static void main(String[] args) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((o1, o2) -> o1 > o2 ? -1 : o1.equals(o2) ? 0 : 1);

        priorityQueue.add(10);
        priorityQueue.add(20);
        priorityQueue.add(3);
        priorityQueue.add(4);
        priorityQueue.add(1000);
        priorityQueue.add(8);

        while (!priorityQueue.isEmpty()) {
            System.out.println(priorityQueue.poll());
        }


    }


}
