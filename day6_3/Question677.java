import java.util.Map;
import java.util.HashMap;

public class Question677{
    class TrieNode{
        Map<Character, TrieNode> children;
        boolean isWord;
        int value;

        public TrieNode(){
            children = new HashMap<Character, TrieNode>();
            isWord = false;
            value = 0;
        }
    }
    
    TrieNode root;
    public Question677(){
        root = new TrieNode();
    }

    public void insert(String key, int val){
        TrieNode cur = root;
        for(char c : key.toCharArray()){
            TrieNode next = cur.children.get(c);
            if(next == null){
                next = new TrieNode();
                cur.children.put(c, next);
            }
            cur = next;
        }
        cur.isWord = true;
        cur.value = val;
    }

    public int sum(String prefix){
        TrieNode cur = root;
        for(char c : prefix.toCharArray()){
            TrieNode next = cur.children.get(c);
            if(next == null)
                return 0;
            cur = next;
        }
        return dfs(cur);
    }

    private int dfs(TrieNode root){
        int sum = 0;
        for(char c: root.children.keySet()){
            sum += dfs(root.children.get(c));
        }
        return sum + root.value;
    }
}
