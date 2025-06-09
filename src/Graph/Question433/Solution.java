package Graph.Question433;

import java.util.*;

public class Solution {
    public int minMutation(String startGene, String endGene, String[] bank) {
        // valid ���������к�������
        Set<String> valid = new HashSet<>();
        // visited ���������������������
        Set<String> visited = new HashSet<>();

        char[] genes = {'A', 'C', 'G', 'T'};

        // valid���ϵĳ�ʼ��
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
        // ���н��г�ʼ�����Ա��ڽ��в�α���
        Queue<String> queue = new LinkedList<>();
        queue.add(startGene);
        visited.add(startGene);
        while (!queue.isEmpty()) {
            int size = queue.size();
            // �൱�ڲ�α�������һ�㶼ȡ����
            for (int i = 0; i < size; i++) {
                String cur = queue.poll();
                // 8����Ϊ�ַ����̶�������8
                for (int j = 0; j < 8; j++) {
                    // 4 ����4����ѡ��ѡ��
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
