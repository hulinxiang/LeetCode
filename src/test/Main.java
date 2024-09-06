package test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        int n = in.nextInt();
        int[][] arr = new int[n][3];
        int count = 0;
        for (int j = 0; j < n; j++) {
            for (int i = 0; i < 3; i++) {
                arr[count][i] = in.nextInt();
            }
            count++; // 数组构建完毕
        }
        Arrays.sort(arr, Comparator.comparingInt(a -> a[0]));
        int ans = 0;
        for (int[] ints : arr) {
            int date = ints[1];
            int wait = ints[2];
            if (date >= ans) {
                ans = date; //必须等到那个时候
            } else {
                //已经超过了这个时间了
                int tmp = date;
                while (tmp < ans) {
                    tmp += wait;
                }
                ans = tmp; //必须等到那个时候
            }
            ans++;//一天只能一个景点
        }
        System.out.println(ans - 1);
    }
}