package Graph.Question433;

import java.util.*;

public class Solution {
    public int minMutation(String startGene, String endGene, String[] bank) {
        // valid 包含了所有合理的组合
        Set<String> valid = new HashSet<>();
        // visited 包含了所有遇到过的组合
        Set<String> visited = new HashSet<>();

        char[] genes = {'A', 'C', 'G', 'T'};

        // valid集合的初始化
        for (String gene : bank) {
            valid.add(gene);
        }

        if (startGene.equals(endGene)) {
            return 0;
        }

        if (!valid.contains(endGene)) {
            return -1;
        }

        int steps = 1;
        // 队列进行初始化，以便于进行层次遍历
        Queue<String> queue = new LinkedList<>();
        queue.add(startGene);
        visited.add(startGene);
        while (!queue.isEmpty()) {
            int size = queue.size();
            // 相当于层次遍历把这一层都取出来
            for (int i = 0; i < size; i++) {
                String cur = queue.poll();
                // 8是因为字符串固定长度是8
                for (int j = 0; j < 8; j++) {
                    // 4 就是4个候选的选择
                    for (int k = 0; k < 4; k++) {
                        if (genes[k] == cur.charAt(j)) {
                            continue;
                        }
                        StringBuffer sb = new StringBuffer(cur);
                        sb.setCharAt(j, genes[k]);
                        String next = sb.toString();
                        if (next.equals(endGene)) {
                            return steps;
                        }
                        if (valid.contains(next) && !visited.contains(next)) {
                            queue.add(next);
                            visited.add(next);
                        }
                    }
                }

            }
            steps++;
        }

        return -1;
    }
}
