import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

// 7.15 - 7.47
// 操你妈
// 有很多小坑
// 1.大字母匹配，就是只要是大的字母就必须一样，小的字母完全不用管
// time complexity is O(NK + M) = O(NK)
// space complexity is O(M)
// 个人认为这个题是这里这里面最难的，需要自己手动构建字典树
// 和一般的字典树例题不一样的是，这个题的search函数的参数比较特别，因为只用大写字母匹配，所以search和参数要做出相应的改变
public class Mianjing12{
    public List<String> autocomplete(String[] words, String word){
        TrieNode root = new TrieNode();
        for(String str : words){
            buildTrie(str, 0, root);
        }
        List<Character> w = new ArrayList<>();
        for(int i = 0;i<word.length();i++){
            char c = word.charAt(i);
            if(c >= 'A' && c <= 'Z') w.add(c);
        }
        List<String> result = new ArrayList<>();
        searchWords(root, w, 0, result);
        return result;
    }

    private void searchWords(TrieNode node, List<Character> word, int index, List<String> result){
        if(index >= word.size()){
            if(node.str != null) result.add(node.str);
            for(Character ch : node.map.keySet()){
                searchWords(node.map.get(ch), word, index+1, result);
            }
        }
        else{
            char c = word.get(index);
            for(Character ch : node.map.keySet()){
                if(ch == c) searchWords(node.map.get(ch), word, index+1, result);
                if(ch >= 'A' && ch <= 'Z') continue;
                else searchWords(node.map.get(ch), word, index, result);
            }
        }
    }

    private void buildTrie(String word, int index, TrieNode node){
        if(index == word.length()){
            node.str = word;
            return;
        }
        char c = word.charAt(index);
        if(!node.map.containsKey(c)) node.map.put(c, new TrieNode());
        buildTrie(word, index+1, node.map.get(c));
    }
}

class TrieNode{
    HashMap<Character, TrieNode> map = new HashMap<>();
    String str= null;
}
