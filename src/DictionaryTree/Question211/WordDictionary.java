package DictionaryTree.Question211;

public class WordDictionary {

    private static class Node {
        Node[] children = new Node[26];
        boolean isEnd;
    }

    private Node root;

    public WordDictionary() {
        root = new Node();
    }

    public void addWord(String word) {
        Node current = root;
        char[] chars = word.toCharArray();
        for (char c : chars) {
            c -= 'a';
            if (current.children[c] == null) {
                current.children[c] = new Node();
            }
            current = current.children[c];
        }
        current.isEnd = true;
    }

    public boolean search(String word) {
        return find(root, word);
    }

    private boolean find(Node root, String word) {
        char[] ch = word.toCharArray();
        Node current = root;
        for (int i = 0; i < ch.length; i++) {
            char c = ch[i];
            if (c == '.') {
                // 如果是'.'的情况，那么就是current下面的children都可以满足要求
                for (Node child : current.children) {
                    if (child == null) {
                        continue;
                    }
                    String nextWord = word.substring(i + 1);
                    if (find(child, nextWord)) {
                        return true;
                    }
                }
                return false;
            } else {
                c -= 'a';
                if (current.children[c] == null) {
                    return false;
                }
            }
            current = current.children[c];
        }
        return current.isEnd;
    }
}
