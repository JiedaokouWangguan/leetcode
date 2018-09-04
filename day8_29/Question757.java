package leetcode.day8_29;

import sun.text.normalizer.Trie;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class Question757 {
    HashSet<String> set = new HashSet<>();
    int[][] delta = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    public List<String> findWords(char[][] board, String[] words) {
        List<String> result = new LinkedList<>();
        TrieNode root = new TrieNode();
        for(String str : words) buildTree(str, root);
        int rows = board.length;
        int cols = board[0].length;
        boolean[][] visited = new boolean[rows][cols];
        for (int row = 0;row<rows;row++){
            for (int col = 0;col<cols;col++){
                search(board, row, col, root, visited);
            }
        }
        for (String str : set) result.add(str);
        return result;
    }

    private void search(char[][] board, int row, int col, TrieNode root, boolean[][] visited){
        if (visited[row][col]) return;
        char c = board[row][col];
        if (!root.map.containsKey(c)) return;
        TrieNode node = root.map.get(c);
        if (node.str != null) set.add(node.str);
        int rows = board.length;
        int cols = board[0].length;
        visited[row][col] = true;
        for (int i = 0;i<4;i++){
            int newRow = row + delta[i][0];
            int newCol = col + delta[i][1];
            if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols) search(board, newRow, newCol, node, visited);
        }
        visited[row][col] = false;
    }

    private void buildTree(String word, TrieNode root){
        char[] chars = word.toCharArray();
        int index = 0;
        while (index < chars.length){
            if (!root.map.containsKey(chars[index])) root.map.put(chars[index], new TrieNode());
            root = root.map.get(chars[index]);
            index += 1;
        }
        root.str = word;
    }

}

class TrieNode{
    HashMap<Character, TrieNode> map = new HashMap<>();
    String str = null;
}
