package test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main1 {
    static class Job {
        int start;
        int end;

        public Job(int start, int duration) {
            this.start = start;
            this.end = duration;
        }

    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        Job[] jpbs = new Job[n];
        for (int i = 0; i < n; i++) {
            int t = in.nextInt();
            int w = in.nextInt();
            jpbs[i] = new Job(t, w);
        }
        Arrays.sort(jpbs, Comparator.comparingInt(j -> j.start));
        PriorityQueue<Job> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(j -> j.end));
        int currentTime = 0;
        int totalWaitTime = 0;
        int index = 0;
        while (index < n || !priorityQueue.isEmpty()) {
            if (priorityQueue.isEmpty() && currentTime < jpbs[index].start) {
                currentTime = jpbs[index].start;
            }

            while (index < n && jpbs[index].start <= currentTime) {
                priorityQueue.add(jpbs[index]);
                index++;
            }
            if (!priorityQueue.isEmpty()) {
                Job job = priorityQueue.poll();
                currentTime += job.end;
                totalWaitTime += currentTime - job.start;
            }

        }
        System.out.println(totalWaitTime);
    }
}
