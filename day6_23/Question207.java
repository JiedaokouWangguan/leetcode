public class Question207{
    public boolean canFinish(int n, int[][] prerequisites) {
        boolean[][] graph = new boolean[n][n];
        int[] visited = new int[n];
        for(int i = 0;i<prerequisites.length;i++){
            graph[prerequisites[i][0]][prerequisites[i][1]] = true;
        }
        for(int i = 0;i<n;i++){
            if(!dfs(i, graph, visited))
                return false;
        }
        return true;
    }
    // 0 not visited
    // 1 is visiting
    // 2 has visited
    private boolean dfs(int index, boolean[][] graph, int[] visited){
        if(visited[index] == 2)
            return true;
        if(visited[index] == 1)
            return false;
        visited[index] = 1;
        for(int i = 0;i<graph[index].length;i++){
            if(graph[index][i]){
                if(!dfs(i, graph, visited))
                    return false;
            }
        }
        visited[index] = 2;
        return true;
    }
}
