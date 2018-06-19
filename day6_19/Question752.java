import java.util.ArrayDeque;
import java.util.HashSet;
public class Question752{
    public int openLock(String[] deadends, String target) {
        ArrayDeque<String> queue = new ArrayDeque<>();
        HashSet<String> set = new HashSet<>();
        HashSet<String> visited = new HashSet<>();
        int count = 0;
        for(String s : deadends){
            set.add(s);
        }
        queue.offer("0000");
        while(queue.size() != 0){
            count += 1;
            int len = queue.size();
            for(int i = 0;i<len;i++){
                String tmp = queue.poll();
                if(set.contains(tmp))
                    continue;
                if(visited.contains(tmp))
                    continue;
                if(target.equals(tmp))
                    return count;
                visited.add(tmp);
                for(int j = 0;j<4;j++){
                    String s1 = null;
                    String s2 = null;
                    if (tmp.charAt(j) == '0')
                        s1 = tmp.substring(0, j) + "9" + tmp.substring(j + 1, 4);
                    else s1 = tmp.substring(0, j) + Character.toString((char) (tmp.charAt(j) - 1)) + tmp.substring(j + 1, 4);
                    if (tmp.charAt(j) == '9')
                        s2 = tmp.substring(0, j) + "0" + tmp.substring(j + 1, 4);
                    else s2 = tmp.substring(0, j) + Character.toString((char) (tmp.charAt(j) + 1)) + tmp.substring(j + 1, 4);
                    if (!visited.contains(s1)) queue.offer(s1);
                    if (!visited.contains(s2)) queue.offer(s2);
                }
            }
        }
        return -1;
    }
}
