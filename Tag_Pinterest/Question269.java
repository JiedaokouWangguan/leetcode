import java.util.HashMap;
import java.util.HashSet;
import java.util.ArrayDeque;

public class Question269{
    public String alienOrder(String[] words) {
        HashMap<Character, Integer> indegree = new HashMap<>();
        HashMap<Character, HashSet<Character>> graph = new HashMap<>();
        for (String s : words)
            for (char c : s.toCharArray()) {
                indegree.put(c, 0);
                graph.put(c, new HashSet<>());
            }

        for (int i = 0; i < words.length - 1; i++) {
            String prev = words[i];
            String next = words[i + 1];
            int len = Math.min(prev.length(), next.length());
            for (int j = 0; j < len; j++) {
                if (prev.charAt(j) == next.charAt(j)) continue;
                char prevChar = prev.charAt(j);
                char nextChar = next.charAt(j);
                if(!graph.get(prevChar).contains(nextChar)){
                    graph.get(prevChar).add(nextChar);
                    indegree.put(nextChar, indegree.get(nextChar) + 1);
                }
                break;
            }
        }

        StringBuilder sb = new StringBuilder();
        ArrayDeque<Character> queue = new ArrayDeque<>();
        for (Character c : indegree.keySet())
            if (indegree.get(c) == 0) queue.offer(c);
        while (queue.size() != 0) {
            Character c = queue.poll();
            sb.append(c);
            if (!graph.containsKey(c)) return "";
            for (Character ch : graph.get(c)) {
                indegree.put(ch, indegree.get(ch) - 1);
                if (indegree.get(ch) == 0) queue.offer(ch);
            }
            graph.remove(c);
        }
        return graph.keySet().size() == 0 ? sb.toString() : "";
    }
}
