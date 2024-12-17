package Graph.Question133;

import java.util.*;

public class Solution {

    static class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

    public Node cloneGraph(Node node) {
        if (node == null) return null;

        // ��һ�� HashMap ���洢ԭ�ڵ㵽��¡�ڵ��ӳ��
        Map<Node, Node> map = new HashMap<>();
        return dfs(node, map);
    }

    // ���������������
    public Node dfs(Node node, Map<Node, Node> map) {
        if (node == null) return null;

        // ����ڵ��Ѿ�����¡��ֱ�ӷ��ؿ�¡�ڵ�
        if (map.containsKey(node)) {
            return map.get(node);
        }

        // ������ǰ�ڵ�Ŀ�¡��������� map
        Node clone = new Node(node.val);
        map.put(node, clone);

        // �ݹ��¡�����ھ�
        for (Node neighbor : node.neighbors) {
            clone.neighbors.add(dfs(neighbor, map));
        }

        return clone;
    }
}
