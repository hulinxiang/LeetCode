package test;

import java.util.*;

public class Solution1 {
    // 优先队列，用于保存路径，按路径长度排序
    PriorityQueue<ArrayList<int[]>> priorityQueue = new PriorityQueue<>(new Comparator<ArrayList<int[]>>() {
        @Override
        public int compare(ArrayList<int[]> o1, ArrayList<int[]> o2) {
            return o1.size() - o2.size();
        }
    });

    Set<Long> set = new HashSet<>();

    int m;
    int n;

    public String getShortestPath(int[][] g) {
        ArrayList<int[]> list = new ArrayList<>();
        list.add(new int[]{0, 0});
        m = g.length;
        n = g[0].length;
        long initial = ((long) 0 << 32) | 0L;
        set.add(initial);
        find(g, list, new int[]{0, 0});
        ArrayList<int[]> ans = priorityQueue.peek();
        StringBuilder sb = new StringBuilder();
        for (int[] pos : ans) {
            sb.append(Arrays.toString(pos)).append(" ");
        }
        return sb.toString();
    }

    public void find(int[][] g, ArrayList<int[]> path, int[] curPos) {
        if (curPos[0] == m - 1 && curPos[1] == n - 1) {
            priorityQueue.add(new ArrayList<>(path));
            return;
        } else {
            int x = curPos[0];
            int y = curPos[1];
            int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
            for (int[] dir : directions) {
                int newX = x + dir[0];
                int newY = y + dir[1];
                if (newX >= 0 && newX < m && newY >= 0 && newY < n && g[newX][newY] == 0) {
                    int[] newPos = new int[]{newX, newY};
                    long i = ((long) newX << 32) | (newY & 0xFFFFFFFFL);
                    if (!set.contains(i)) {
                        set.add(i);
                        path.add(newPos);
                        find(g, path, newPos);
                        path.remove(path.size() - 1); // 回溯
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();
        int[][] m = new int[6][10];
        m[0] = new int[]{0, 2, 0, 0, 0, 0, 0, 0, 0, 0};
        m[1] = new int[]{0, 2, 0, 0, 2, 2, 2, 2, 2, 0};
        m[2] = new int[]{0, 2, 0, 0, 2, 0, 0, 2, 0, 0};
        m[3] = new int[]{0, 2, 0, 0, 0, 0, 0, 2, 0, 0};
        m[4] = new int[]{0, 2, 2, 2, 2, 2, 0, 2, 0, 0};
        m[5] = new int[]{0, 0, 0, 0, 0, 0, 0, 2, 0, 0};
        System.out.println(solution1.getShortestPath(m));
    }
}
