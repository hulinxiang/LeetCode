package Tree.Question117;

import java.util.ArrayList;
import java.util.List;

public class Solution1 {
    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    /**
     * DFS
     *
     * @param root
     * @return
     */
    public Node connect(Node root) {
        List<Node> list = new ArrayList<>();
        dfs(list, root, 0);
        return root;
    }

    private void dfs(List<Node> list, Node root, int layer) {
        if (root == null) {
            return;
        }
        if (list.size() == layer) {
            list.add(root);
        } else {
            Node pre = list.get(layer);
            pre.next = root;
            list.set(layer, root);
        }
        dfs(list, root.left, layer + 1);
        dfs(list, root.right, layer + 1);
    }


}

