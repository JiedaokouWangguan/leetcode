import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.ArrayDeque;

public class Question126{
    HashMap<String, Integer> distance = new HashMap<>();
    HashMap<String, HashSet<String>> neighbors = new HashMap<>();
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> words = new HashSet<>(wordList);
        List<List<String>> result = new ArrayList<>();
        if(!words.contains(endWord)) return result;
        //for(String word: words) getNeighbors(word, words);
        int steps = bfs(beginWord, endWord, words);
        if(steps == -1) return result;
        distance.put(endWord, steps);
        List<String> tmpResult = new ArrayList<String>();
        tmpResult.add(beginWord);
        dfs(result, tmpResult, 0, steps, endWord, words);
        return result;
    }

    private void dfs(List<List<String>> result, List<String> tmpResult, int curStep, int steps, String end, HashSet<String> words){
        if(curStep == steps){
            if(tmpResult.get(tmpResult.size()-1).equals(end)){
                result.add(new ArrayList<>(tmpResult));
            }
            return;
        }

        String cur = tmpResult.get(tmpResult.size()-1);
        HashSet<String> nei = getNeighbors(cur, words);
        for(String n : nei){
            if(!distance.containsKey(n) || distance.get(n) != curStep + 1) continue;
            tmpResult.add(n);
            dfs(result, tmpResult, curStep+1, steps, end, words);
            tmpResult.remove(tmpResult.size()-1);
        }
    }

    private int bfs(String begin, String end, HashSet<String> words){
        int step = 0;
        HashSet<String> visited = new HashSet<>();
        visited.add(begin);
        ArrayDeque<String> queue = new ArrayDeque<>();
        queue.offer(begin);
        while(queue.size() > 0){
            int len = queue.size();
            for(int i = 0;i<len;i++){
                String cur = queue.poll();
                if(cur.equals(end)) return step;
                if(!distance.containsKey(cur)) distance.put(cur, step);
                HashSet<String> nei = getNeighbors(cur, words);
                for(String s : nei){
                    if(visited.contains(s)) continue;
                    visited.add(s);
                    queue.offer(s);
                }
            }
            step += 1;
        }
        return -1;
    }

    private HashSet<String> getNeighbors(String s, HashSet<String> words){
        if(neighbors.containsKey(s)) return neighbors.get(s);
        char[] chars = s.toCharArray();
        HashSet<String> tmpResult = new HashSet<>();
        for(int i = 0;i<chars.length;i++){
            char cur = chars[i];
            for(int j = 0;j<26;j++){
                if(cur == 'a' + j) continue;
                chars[i] = (char)('a'+j);
                String tmp = new String(chars);
                if(words.contains(tmp)) tmpResult.add(tmp);
                chars[i] = cur;
            }
        }
        neighbors.put(s, tmpResult);
        return tmpResult;
    }
}
