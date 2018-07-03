import java.util.HashMap;
import java.util.ArrayList;

class WordDistance {
    String[] words = null;
    HashMap<String, ArrayList<Integer>> map = new HashMap<>();
    public WordDistance(String[] words) {
        this.words = words;
        for(int i = 0;i<words.length;i++){
            String w = words[i];
            if(!map.containsKey(w))
                map.put(w, new ArrayList<Integer>());
            map.get(w).add(i);
        }
    }

    public int shortest(String word1, String word2) {
        ArrayList<Integer> list1 = map.get(word1);
        ArrayList<Integer> list2 = map.get(word2);
        int index1 = 0;
        int index2 = 0;
        int result = words.length;
        for(;index1<list1.size() && index2 < list2.size();){
            if(list1.get(index1) < list2.get(index2)){
                result = Math.min(result, list2.get(index2) - list1.get(index1));
                index1 += 1;
            }
            else{
                result = Math.min(result, list1.get(index1) - list2.get(index2));
                index2 += 1;
            }
        }
        return result;
    }
}
