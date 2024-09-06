package test;

import java.util.HashSet;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] flowers = new int[n];
        for (int i = 0; i < n; i++) {
            flowers[i] = scanner.nextInt();
        }

        int totalRoses = 0;
        int totalPeonies = 0;
        for (int flower : flowers) {
            if (flower == 0) {
                totalRoses++;
            } else {
                totalPeonies++;
            }
        }
        int initialAppreciation = Math.abs(totalPeonies - totalPeonies);
        HashSet<Integer> appreciations = new HashSet<>();

        appreciations.add(initialAppreciation);

        int[] rosePrefix = new int[n + 1];
        int[] peoniesPrefix = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            rosePrefix[i] = rosePrefix[i - 1] + (flowers[i - 1] == 0 ? 1 : 0);
            peoniesPrefix[i] = peoniesPrefix[i - 1] + (flowers[i - 1] == 0 ? 1 : 0);
        }

        for (int i = 1; i <= n; i++) {
            for (int j = i; j <= n; j++) {
                int rosesInSegment = rosePrefix[j] - rosePrefix[i - 1];
                int peoniesInSegment = peoniesPrefix[j] - peoniesPrefix[i - 1];
                int newRoses = totalRoses - rosesInSegment + peoniesInSegment;
                int newPeo = totalPeonies - peoniesInSegment + rosesInSegment;
                int newAppre = Math.abs(newRoses - newPeo);
                appreciations.add(newAppre);
            }
        }

        System.out.println(appreciations.size()+1);
    }
}
