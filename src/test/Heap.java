package test;

import java.util.PriorityQueue;

public class Heap {
    static PriorityQueue<Integer> maxHeap=new PriorityQueue<>((a,b)->b-a);
    static PriorityQueue<Integer> minHeap=new PriorityQueue<>();

    public static void main(String[] args) {
        int[] n=new int[100];
        for(int i=0;i<100;i++){
            maxHeap.add(i);
            minHeap.add(i);
        }
        while(!minHeap.isEmpty()){
            System.out.println(minHeap.poll());
        }
        System.out.println("==============");
        while(!maxHeap.isEmpty()){
            System.out.println(maxHeap.poll());
        }

    }

}
