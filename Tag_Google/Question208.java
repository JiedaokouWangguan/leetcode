import java.util.HashMap;


class Trie {
    // 2.03 - 2.13, 11mins
    /** Initialize your data structure here. */
   
    TrieNode root = new TrieNode();
    public Trie() {

    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        insert(root, word, 0);
    }

    private void insert(TrieNode node, String word, int index){
        if(index == word.length()){
            node.str = word;
            return;
        }
        char c = word.charAt(index);
        if(!node.map.containsKey(c)) node.map.put(c, new TrieNode());
        insert(node.map.get(c), word, index+1);
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        return search(root, word, 0);    
    }

    private boolean search(TrieNode node, String word, int index){
        if(index == word.length()){
            if(node.str != null && node.str.equals(word))
                return true;
            else
                return false;
        }
        char c = word.charAt(index);
        if(!node.map.containsKey(c)) return false;
        return search(node.map.get(c), word, index+1);
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        return startsWith(root, prefix, 0);
    }

    private boolean startsWith(TrieNode node, String prefix, int index){
        if(index == prefix.length()) return true;
        char c = prefix.charAt(index);
        if(!node.map.containsKey(c)) return false;
        return startsWith(node.map.get(c), prefix, index+1);
    }
}

class TrieNode{
    String str = null;
    HashMap<Character, TrieNode> map = new HashMap<>();
}
