import java.util.HashSet;
import java.util.ArrayDeque;

public class Question433{
    public int minMutation(String start, String end, String[] bank) {
        HashSet<String> set = new HashSet<>();
        for(String s : bank) set.add(s);
        if(!set.contains(end)) return -1;
        ArrayDeque<String> queue = new ArrayDeque<String>();
        char[] chars = new char[]{'A', 'C', 'G', 'T'};
        queue.offer(start);

        int step = 0;
        while(queue.size() != 0){
            int len = queue.size();
            for(int i = 0;i<len;i++){
                String tmp = queue.poll();
                if(tmp.equals(end)) return step;

                for(int j = 0;j<tmp.length();j++){
                    for(int k = 0;k<4;k++){
                        if(tmp.charAt(j) == chars[k]) continue;
                        String newTmp = tmp.substring(0, j) + chars[k] + tmp.substring(j+1);
                        if(!set.contains(newTmp))
                            continue;
                        else{
                            set.remove(newTmp);
                            queue.offer(newTmp);
                        }
                    }
                }
            }
            step += 1;
        }
        return -1;
    }
}
