package DictionaryTree.Question212;

import java.util.*;

class Solution {

    public class Tree {
        String word;
        HashMap<Character, Tree> hashMap;

        Tree() {
            word = "";
            hashMap = new HashMap<Character, Tree>();
        }

        public void insert(String word) {
            Tree cur = this;
            for (char c : word.toCharArray()) {
                if (!cur.hashMap.containsKey(c)) {
                    cur.hashMap.put(c, new Tree());
                }
                cur = cur.hashMap.get(c);
            }
            cur.word = word;
        }

    }

    int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public List<String> findWords(char[][] board, String[] words) {

        Tree tree = new Tree();
        // ¹¹Ôì×ÖµäÊ÷
        for (String word : words) {
            tree.insert(word);
        }

        Set<String> res = new HashSet<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs(i, j, tree, board, res);
            }
        }
        return new ArrayList<>(res);
    }

    public void dfs(int i, int j, Tree cur, char[][] board, Set<String> res) {
        if (!cur.hashMap.containsKey(board[i][j])) {
            return;
        }
        char c = board[i][j];
        cur = cur.hashMap.get(c);
        if (!"".equals(cur.word)) {
            res.add(cur.word);
        }
        board[i][j] = '%';
        for (int[] dir : dirs) {
            int x = i + dir[0];
            int y = j + dir[1];
            if (x >= 0 && y >= 0 && x < board.length && y < board[0].length) {
                dfs(x, y, cur, board, res);
            }
        }
        board[i][j] = c;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        char[][] board = new char[][]{{'o', 'a', 'a', 'n'}, {'e', 't', 'a', 'e'}, {'i', 'h', 'k', 'r'}, {'i', 'f', 'l', 'v'}};
        String[] words = {"oath", "pea", "eat", "rain"};
        List<String> res = solution.findWords(board, words);
        for (String word : res) {
            System.out.println(word);
        }
    }
}