import java.util.ArrayDeque;

public class Question261{

    public boolean validTree(int n, int[][] edges) {
        int[][] graph = new int[n][n];
        for (int[] e : edges) {
            graph[e[0]][e[1]] = 1;
            graph[e[1]][e[0]] = 1;
        }
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        int[] visited = new int[n];
        visited[0] = 0;
        int count = 0;
        queue.offer(0);
        while (queue.size() != 0) {
            int cur = queue.poll();
            count += 1;
            for (int i = 0; i < n; i++) {
                if (graph[cur][i] == 1) {
                    if (visited[i] == 1) {
                        return false;
                    } else {
                        visited[i] = 1;
                        graph[i][cur] = 0;
                        queue.offer(i);
                    }
                }
            }
        }
        return count == n;
    }
}
