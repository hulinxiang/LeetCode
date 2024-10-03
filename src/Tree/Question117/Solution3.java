package Tree.Question117;

public class Solution3 {
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
     * BFS+Á´±í
     *
     * @param root
     * @return
     */
    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        Node dummy = new Node();
        Node cur = root;
        while (cur != null) {
            dummy.next = null;
            Node next = dummy;
            while (cur != null) {
                if (cur.left != null) {
                    next.next = cur.left;
                    next = next.next;
                }
                if (cur.right != null) {
                    next.next = cur.right;
                    next = next.next;
                }
                cur = cur.next;
            }
            cur = dummy.next;
        }
        return root;
    }

}
