import java.util.ArrayDeque;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;

public class Question636{
    public int[] exclusiveTime(int n, List<String> logs) {
        int curTime = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        ArrayDeque<Job> stack = new ArrayDeque<>();
        for(String log : logs){
            String[] info = log.split(":");
            if(stack.size() == 0){
                Job newJob = new Job(Integer.parseInt(info[0]), Integer.parseInt(info[2]));
                stack.push(newJob);
                continue;
            }
            if(info[1].equals("end")){
                Job last = stack.pop();
                map.put(last.id, map.getOrDefault(last.id, 0) + Integer.parseInt(info[2])- last.started + 1);
                if(stack.size() !=0)
                    stack.peek().started = Integer.parseInt(info[2]) + 1;
            }
            else{
                int lastStarted = stack.peek().started;
                stack.peek().started = 0;
                Job newJob = new Job(Integer.parseInt(info[0]), Integer.parseInt(info[2]));
                map.put(stack.peek().id, map.getOrDefault(stack.peek().id, 0) + newJob.started-lastStarted);
                stack.push(newJob);
            }
        }
        int[] result = new int[n];
        for(int i = 0;i<n;i++){
            result[i] = map.get(i);
        }
        return result;
    }
}

class Job{
    int id;
    int started;
    public Job(int i, int s){
        id = i;
        started = s;
    }
}
