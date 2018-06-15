import java.util.TreeMap;

class MyCalendarThree{
    TreeMap<Integer, Integer> map;

    public MyCalendarThree(){
        map = new TreeMap<>();
    }

    public int book(int start, int end){
        map.put(start, map.getOrDefault(start, 0) + 1);
        map.put(end, map.getOrDefault(end, 0) - 1);
        
        int cur = 0;
        int result = 0;
        for(int v : map.values()){
            cur += v;
            if(cur > result)
                result = cur;
        }
        return result;
    }
}
