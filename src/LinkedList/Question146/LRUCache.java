package LinkedList.Question146;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    private static class Node {
        int key, value;
        Node prev, next;

        Node(int k, int v) {
            key = k;
            value = v;
        }
    }

    private final int capacity;
    private final Node dummy = new Node(0, 0); // �ڱ��ڵ�
    private final Map<Integer, Node> keyToNode = new HashMap<>();

    public LRUCache(int capacity) {
        this.capacity = capacity;
        dummy.prev = dummy;
        dummy.next = dummy;
    }

    public int get(int key) {
        Node node = getNode(key);
        return node != null ? node.value : -1;
    }

    public void put(int key, int value) {
        Node node = getNode(key);
        if (node != null) { // ���Ȿ��
            node.value = value; // ���� value
            return;
        }
        node = new Node(key, value); // ����
        keyToNode.put(key, node);
        pushFront(node); // ����������
        if (keyToNode.size() > capacity) { // ��̫����
            Node backNode = dummy.prev;
            keyToNode.remove(backNode.key);
            remove(backNode); // ȥ�����һ����
        }
    }

    private Node getNode(int key) {
        if (!keyToNode.containsKey(key)) { // û���Ȿ��
            return null;
        }
        Node node = keyToNode.get(key); // ���Ȿ��
        remove(node); // ���Ȿ������
        pushFront(node); // ����������
        return node;
    }

    // ɾ��һ���ڵ㣨���һ���飩
    private void remove(Node x) {
        x.prev.next = x.next;
        x.next.prev = x.prev;
    }

    // ������ͷ���һ���ڵ㣨��һ������������棩
    private void pushFront(Node x) {
        x.prev = dummy;
        x.next = dummy.next;
        x.prev.next = x;
        x.next.prev = x;
    }

}
