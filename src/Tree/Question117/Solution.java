package Tree.Question117;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
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


    public Node connect(Node root) {
        List<Node>[] lists = new ArrayList[6000];
        Arrays.setAll(lists, i -> new ArrayList<>());
        fun1(root, 0, lists);
        for (List<Node> list : lists) {
            fun2(list);
        }
        return root;
    }


    public void fun1(Node root, int layer, List<Node>[] lists) {
        if (root == null) {
            return;
        }
        lists[layer].add(root);
        fun1(root.left, layer + 1, lists);
        fun1(root.right, layer + 1, lists);
    }

    public void fun2(List<Node> list) {
        for (int i = 0; i < list.size() - 1; i++) {
            Node pre = list.get(i);
            Node post = list.get(i + 1);
            pre.next = post;
        }
    }


}
