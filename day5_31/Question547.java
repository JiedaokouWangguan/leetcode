public class Question547{

    int count = 0;
    public int findCircleNum(int[][] M){
        int n = M.length;
        boolean[] visited = new boolean[n];
        for(int i = 0;i<n;i++){
            if(!visited[i])
                count += 1;
            dfs(M, i, visited);          
        }
        return count;
    }

    private void dfs(int[][] M, int i, boolean[] visited){
        if(visited[i])
            return;
        visited[i] = true;
        for(int j = 0;j<M.length;j++){
            if(M[i][j] == 1){
                dfs(M, j, visited);
            }
        }
    }
}
