package DictionaryTree.Question208;

public class Trie {

    static class Node {
        Node[] sons = new Node[26];
        boolean isEnd;
    }

    final Node root = new Node();

    public void insert(String word) {
        char[] words = word.toCharArray();
        Node cur = root;
        for (char c : words) {
            c -= 'a';
            if (cur.sons[c] == null) {
                cur.sons[c] = new Node();
            }
            cur = cur.sons[c];
        }
        cur.isEnd = true;
    }

    public boolean search(String word) {
        return find(word) == 1;
    }

    public boolean startsWith(String prefix) {
        return find(prefix) != 0;
    }

    public int find(String word) {
        /**
         * 一个公共函数，用来帮助search和startWith，如果完全匹配，则返回1，
         * 如果是前缀相同则返回2，
         * 如果没有找到则返回0
         */
        Node cur = root;
        char[] words = word.toCharArray();
        for (char c : words) {
            c -= 'a';
            // 因为没有，所以直接不匹配，返回0
            if (cur.sons[c] == null) {
                return 0;
            }
            cur = cur.sons[c];
        }
        // 如果已经结束了，而且完全匹配，那么返回1，否则返回2
        return cur.isEnd ? 1 : 2;
    }

}


/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
