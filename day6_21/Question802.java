import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Question802{
    int[] isTerminal;
    public List<Integer> eventualSafeNodes(int[][] graph) {
        isTerminal = new int[graph.length];
        // 0 un 1 safe 2 not safe
        List<Integer> result = new ArrayList<Integer>();
        for(int i = 0;i<graph.length;i++){
            if(isTer(i, graph))
                result.add(i);
        }
        return result;
    }

    private boolean isTer(int index, int[][] graph){
        if(isTerminal[index] != 0)
            return isTerminal[index] == 1;
        isTerminal[index] = 2;
        for(int i = 0;i<graph[index].length;i++){
            if(!isTer(graph[index][i], graph))
                return false;
        }
        isTerminal[index] = 1;
        return true;
    }
}
