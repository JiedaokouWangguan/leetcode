import java.util.HashSet;
import java.util.HashMap;

public class Question890{
    public boolean possibleBipartition(int N, int[][] dislikes) {
        HashMap<Integer, HashSet<Integer>> map = new HashMap<>();
        for (int[] i : dislikes) {
            int from = i[0];
            int to = i[1];
            if (!map.containsKey(from)) map.put(from, new HashSet<Integer>());
            if (!map.containsKey(to)) map.put(to, new HashSet<Integer>());

            map.get(from).add(to);
            map.get(to).add(from);
        }

        boolean[] visited = new boolean[N + 1];
        boolean[] type = new boolean[N + 1];
        for (int i = 1; i <= N; i++) {
            if (visited[i]) continue;
            visited[i] = true;
            if (!dfs(i, visited, type, map)) return false;
        }
        return true;
    }

    private boolean dfs(int index, boolean[] visited, boolean[] type,
            HashMap<Integer, HashSet<Integer>> map) {
        if (!map.containsKey(index)) return true;
        for (Integer i : map.get(index)) {
            if (!visited[i]) {
                visited[i] = true;
                type[i] = !type[index];
                if (!dfs(i, visited, type, map)) return false;
            } else if (type[index] == type[i]) return false;
        }
        return true;
    }
}
