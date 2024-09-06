package test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // ע�� hasNext �� hasNextLine ������
        int n = in.nextInt();
        int[][] arr = new int[n][3];
        int count = 0;
        for (int j = 0; j < n; j++) {
            for (int i = 0; i < 3; i++) {
                arr[count][i] = in.nextInt();
            }
            count++; // ���鹹�����
        }
        Arrays.sort(arr, Comparator.comparingInt(a -> a[0]));
        int ans = 0;
        for (int[] ints : arr) {
            int date = ints[1];
            int wait = ints[2];
            if (date >= ans) {
                ans = date; //����ȵ��Ǹ�ʱ��
            } else {
                //�Ѿ����������ʱ����
                int tmp = date;
                while (tmp < ans) {
                    tmp += wait;
                }
                ans = tmp; //����ȵ��Ǹ�ʱ��
            }
            ans++;//һ��ֻ��һ������
        }
        System.out.println(ans - 1);
    }
}