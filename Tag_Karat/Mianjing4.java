import java.util.HashSet;
import java.util.Set;
import java.util.HashMap;
import java.util.Arrays;
import java.util.Comparator;
import java.util.ArrayDeque;
import java.util.List;
import java.util.ArrayList;

public class Mianjing4{

    // 11.08-11.29
    // all O(n)
    // 最后一个的要求是输入第一个长于3的序列，所以有多少输出多少，不是到三个就停
    // 时间复杂度都是On，因为就是把所有记录线性扫描一次就行了。
    
    public Set<String> getList(String[][] record){
        Set<String> set = new HashSet<>();
        HashMap<String, Integer> map = new HashMap<>();
        for(String[] rec : record){
            String id = rec[0];
            String op = rec[1];
            if(!map.containsKey(id)) map.put(id, 0);
            if(op.equals("exit")){
                map.put(id, 0);
            }
            else{
                if(map.get(id) == 1) set.add(id);
                map.put(id, 1);
            }
        }
        return set;
    }

    public Set<String> getList1(String[][] record){
        Set<String> set = new HashSet<>();
        HashMap<String, Integer> map = new HashMap<>();
        for(String[] rec : record){
            String id = rec[0];
            String op = rec[1];
            if(!map.containsKey(id)) map.put(id, 0);
            if(op.equals("exit")){
                if(map.get(id) == 0) set.add(id);
                map.put(id, 0);
            }
            else{
                map.put(id, 1);
            }
        }
        return set;
    }

    public HashMap<String, List<Integer>> getMap(String[][] records){
        Arrays.sort(records, new Comparator<String[]>(){
            @Override
            public int compare(String[] s1, String[] s2){
                return Integer.parseInt(s1[1]) - Integer.parseInt(s2[1]);
            }
        });
        Set<String> ignore = new HashSet<String>();
        HashMap<String, ArrayDeque<Integer>> map = new HashMap<>();
        HashMap<String, List<Integer>> result = new HashMap<>();
        for(String[] record : records){
            String id = record[0];
            if(ignore.contains(id)) continue;
            int time = Integer.parseInt(record[1]);
            if(!map.containsKey(id)) map.put(id, new ArrayDeque<Integer>());
            if(map.get(id).size() > 0 && time - map.get(id).peek() > 100){
                if(map.get(id).size() >= 3){
                    ignore.add(id);
                    List<Integer> tmpResult = new ArrayList<Integer>();
                    while(map.get(id).size() > 0) tmpResult.add(map.get(id).poll());
                    result.put(id, tmpResult);
                }
                while(map.get(id).size() > 0 && time - map.get(id).peek() > 100) map.get(id).poll();
            }
            map.get(id).offer(time);
        }
        return result;
    }
}
