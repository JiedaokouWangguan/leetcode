import java.util.List;
import java.util.ArrayList;

public class Question648{
    public String replaceWords(List<String> dict, String sentence){
        TrieNode root = new TrieNode();
        
        for(String dic : dict){
            TrieNode cur = root;
            for(char c : dic.toCharArray()){
                if(cur.children[c-'a'] == null)
                    cur.children[c-'a'] = new TrieNode();
                cur = cur.children[c-'a'];
            }
            cur.word = dic;
        }
        // build the trie
        
        StringBuilder sb = new StringBuilder();
        String[] sentences = sentence.split("\\s+");
        for(String word : sentences){
            TrieNode cur = root;
            for(char c : word.toCharArray()){
                if(cur.children[c-'a'] == null || cur.word != null)
                    break;
                cur = cur.children[c - 'a'];
            }
            String tmp = cur.word == null ? word : cur.word;
            sb.append(tmp);
            sb.append(" ");
        }
        String result = sb.toString();
        return result.substring(0, result.length()-1);
    }
}

class TrieNode{
    TrieNode[] children;
    String word = null;
    public TrieNode(){
        children = new TrieNode[26];
    }
}
