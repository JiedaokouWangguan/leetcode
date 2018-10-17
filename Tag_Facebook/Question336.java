import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

public class Question336{
    HashMap<String, Boolean> isPalin = new HashMap<>();
    public List<List<Integer>> palindromePairs(String[] words) {
        TrieNode root = new TrieNode();
        for(int i = 0;i<words.length;i++){
            StringBuilder sb = new StringBuilder(words[i]);
            String w = sb.reverse().toString();
            buildTree(w, 0, root, i);
        }      
        List<List<Integer>> result = new ArrayList<>();
        for(int i = 0;i<words.length;i++){
            List<Integer> tmpResult = new ArrayList<>();
            getList(root, 0, words[i], tmpResult);
            if(tmpResult.size() > 0){
                for(Integer in : tmpResult){
                    if(in == i) continue;
                    List<Integer> tr = new ArrayList<>();
                    tr.add(i);
                    tr.add(in);
                    result.add(tr);
                }
            }  
        }      
        return result;
    }          

    private void getList(TrieNode node, int startFrom, String s, List<Integer> tmpResult){
        if(node.str != null){
            if(isStrPalin(s.substring(startFrom))){
                tmpResult.add(node.i);
            }  
        }   
        if(startFrom == s.length()){
            for(Integer i : node.indices)
                tmpResult.add(i);
            return;
        }      


        char c = s.charAt(startFrom);
        if(node.map.containsKey(c))
            getList(node.map.get(c), startFrom+1, s, tmpResult);
    } 
    private void buildTree(String word, int startFrom, TrieNode node, int index){
        if(word.length() == startFrom){
            node.str = word;
            node.i = index;
            return;
        }     
        if(isStrPalin(word.substring(startFrom))) node.indices.add(index);
        char c = word.charAt(startFrom);
        if(!node.map.containsKey(c)) node.map.put(c, new TrieNode());
        buildTree(word, startFrom+1, node.map.get(c), index);
    }         

    private boolean isStrPalin(String s){
        if(isPalin.containsKey(s)) return isPalin.get(s);
        int left = 0;
        int right = s.length()-1;
        boolean res = true;
        while(left < right){
            if(s.charAt(left) != s.charAt(right)){
                res = false;
                break;
            } 
            left += 1;
            right -= 1;
        }     
        isPalin.put(s, res);
        return res;
    }    
}

class TrieNode{
    HashMap<Character, TrieNode> map = new HashMap<>();
    String str = null;
    int i = -1;
    List<Integer> indices = new ArrayList<>();
}
