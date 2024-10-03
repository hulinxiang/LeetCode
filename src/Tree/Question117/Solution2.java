package Tree.Question117;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution2 {
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
     * BFS
     *
     * @param root
     * @return
     */
    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        List<Node> queue = new ArrayList<>();
        queue.add(root);
        List<Node> tmp;
        while (!queue.isEmpty()) {
            tmp = queue;
            queue = new ArrayList<>();
            for (int i = 0; i < tmp.size(); i++) {
                Node node = tmp.get(i);
                if (i > 0) {
                    tmp.get(i - 1).next = node;
                }
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
        }
        return root;

    }

}


