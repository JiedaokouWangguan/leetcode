package leetcode.day5_13;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Song on 2018/5/13.
 */
public class Question798
{
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> tmp = new ArrayList<>();
        tmp.add(0);
        backtrack(list, tmp, 0, graph.length-1, graph);
        return list;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> tmp, int index, int target, int[][] graph)
    {
        if (index == target)
            result.add(new ArrayList<>(tmp));

        for (int i = 0;i<graph[index].length;i++)
        {
            tmp.add(graph[index][i]);
            backtrack(result, tmp, graph[index][i], target, graph);
            tmp.remove(tmp.size()-1);
        }
    }
}
