package pdd.Q2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine().trim());
        int[] arr = new int[n + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int INF = Integer.MAX_VALUE;
        int[] dist = new int[n + 1];
        Arrays.fill(dist, INF);

        Deque<Integer> dq = new ArrayDeque<>();
        dist[1] = 0;
        dq.add(1);
        while (!dq.isEmpty()) {
            int u = dq.pollFirst();
            int v = arr[u];
            if (dist[v] > dist[u]) {
                dist[v] = dist[u];
                dq.addFirst(v);
            }
            if (u - 1 >= 1 && dist[u - 1] > dist[u] + 1) {
                dist[u - 1] = dist[u] + 1;
                dq.addLast(u - 1);
            }

            if (u + 1 <= n && dist[u + 1] > dist[u] + 1) {
                dist[u + 1] = dist[u] + 1;
                dq.addLast(u + 1);
            }

        }
        for (int i = 1; i <= n; i++) {
            if (i > 1) {
                System.out.print(" ");
            }
            System.out.print(dist[i]);
        }
        System.out.println();
    }
}
