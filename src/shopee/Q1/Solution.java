package shopee.Q1;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    // x, y, z 代表三个石碓
    public int maxPoint(int x, int y, int z) {
        int[] a = new int[]{x, y, z};
        int result = 0;
        while (true){
            Arrays.sort(a);
            if (a[1]>0&&a[2]>0){
                a[1]--;
                a[2]--;
                result++;
            }else {
                break;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] strings = str.split(",");
        int x = Integer.parseInt(strings[0]);
        int y = Integer.parseInt(strings[1]);
        int z = Integer.parseInt(strings[2]);
        System.out.println(new Solution().maxPoint(x,y,z));
        sc.close();
    }
}
