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

        // 用一个 HashMap 来存储原节点到克隆节点的映射
        Map<Node, Node> map = new HashMap<>();
        return dfs(node, map);
    }

    // 深度优先搜索函数
    public Node dfs(Node node, Map<Node, Node> map) {
        if (node == null) return null;

        // 如果节点已经被克隆，直接返回克隆节点
        if (map.containsKey(node)) {
            return map.get(node);
        }

        // 创建当前节点的克隆并将其加入 map
        Node clone = new Node(node.val);
        map.put(node, clone);

        // 递归克隆所有邻居
        for (Node neighbor : node.neighbors) {
            clone.neighbors.add(dfs(neighbor, map));
        }

        return clone;
    }
}
