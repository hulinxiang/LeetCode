package shopee.Q3;

import java.util.Scanner;

public class Solution {
    private static class User {
        int toPut;
    }

    static int curWeight = 0;

    public int checkWinner(int weight) {
        User a = new User();
        User b = new User();
        User c = new User();
        User[] users = {c, a, b};
        a.toPut = 1;
        b.toPut = 1;
        if (weight < 2) {
            return 0; // 不是c压垮的
        }
        curWeight = 2;
        int mark = 0; // 0代表要去替换掉first，1代表替换second
        User first = a;
        User second = b;
        while (true) {
            for (User u : users) {
                u.toPut = first.toPut + second.toPut;
                if (mark == 0) {
                    first = u;
                    mark = 1;
                } else {
                    second = u;
                    mark = 0;
                }
                if (u.toPut + curWeight > weight) {
                    if (u == c) {
                        return 1;
                    } else {
                        return 0;
                    }
                } else {
                    curWeight += u.toPut;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        System.out.println(new Solution().checkWinner(t));
        sc.close();
    }

}
