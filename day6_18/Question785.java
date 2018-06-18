import java.util.Arrays;

public class Question785{
    public boolean isBipartite(int[][] graph){
        int[] group = new int[graph.length];
        Arrays.fill(group, -1);
        for(int i = 0;i<group.length;i++){
            if(group[i] == -1 && !dfs(graph, group, i, 0))
                return false;
        }
        return true;
    }

    private boolean dfs(int[][] graph, int[] group, int index, int value){
        if(group[index] != -1)
            return group[index] == value;
        group[index] = value;
        for(int next : graph[index]){
            if(!dfs(graph, group, next, 1 - value))
                return false;
        }
        return true;
    }
}
