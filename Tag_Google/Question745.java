import java.util.HashMap;
import java.util.HashSet;

class WordFilter {
    HashMap<String, Integer> pri = new HashMap<>();
    TrieNode head = new TrieNode();
    TrieNode tail = new TrieNode();
    public WordFilter(String[] words) {
        for(int i = 0;i<words.length;i++){
            StringBuilder sb = new StringBuilder(words[i]);
            String reverse = sb.reverse().toString();
            build(head, words[i], 0, false);
            build(tail, reverse, 0, true);
            pri.put(words[i], i);
        }
    }

    private void build(TrieNode node, String word, int index, boolean reverse){
        if(index == word.length()){
            if(!reverse)
                node.str = word;
            else{
                StringBuilder sb = new StringBuilder(word);
                node.str = sb.reverse().toString();
            }
            return;
        }
        char c = word.charAt(index);
        if(!node.map.containsKey(c)) node.map.put(c, new TrieNode());
        build(node.map.get(c), word, index+1, reverse);
    }

    public int f(String prefix, String suffix) {
        StringBuilder sb = new StringBuilder(suffix);
        suffix = sb.reverse().toString();
        HashSet<String> headSet = getSet(head, prefix, 0);
        HashSet<String> tailSet = getSet(tail, suffix, 0);
        int maxPri = -1;
        for(String str : headSet){
            if(!tailSet.contains(str)) continue;
            if(pri.get(str) > maxPri){
                maxPri = pri.get(str);
            }
        }
        return maxPri;
    }

    private HashSet<String> getSet(TrieNode node, String str, int index){
        HashSet<String> set = new HashSet<>();
        getSet(node, str, index, set);
        return set;
    }
    private void getSet(TrieNode node, String str, int index, HashSet<String> set){
        if(index < str.length()){
            char c = str.charAt(index);
            if(!node.map.containsKey(c)) return;
            getSet(node.map.get(c), str, index+1, set);
        }
        else{
            if(node.str != null) set.add(node.str);
            for(Character key : node.map.keySet()){
                getSet(node.map.get(key), str, index, set);
            }
        }
    }
}

class TrieNode{
    String str = null;
    HashMap<Character, TrieNode> map = new HashMap<>();
}
