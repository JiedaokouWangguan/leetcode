import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;

public class Question210{
    ArrayDeque<Integer> stack = new ArrayDeque<>();
    HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] visited = new int[numCourses];
        for(int[] a : prerequisites){
            int post = a[0];
            int pre = a[1];
            if(!map.containsKey(post)) map.put(post, new ArrayList<Integer>());
            if(!map.containsKey(pre)) map.put(pre, new ArrayList<Integer>());
            map.get(post).add(pre);
        }

        for(int i = 0;i<numCourses;i++){
            if(!dfs(visited, i))
                return new int[0];
        }
        int[] result = new int[numCourses];
        for(int i = numCourses-1;i >= 0;i--){
            result[i] = stack.pop();
        }
        return result;
    }

    private boolean dfs(int[] visited, int index){
        if(visited[index] == 1) return true;
        if(visited[index] == 2) return false;
        visited[index] = 2;

        if(map.containsKey(index)){
            for(int i : map.get(index))
                if(!dfs(visited, i))
                    return false;
        }
        stack.push(index);
        visited[index] = 1;
        return true;
    }
}
