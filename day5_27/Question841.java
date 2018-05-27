import java.util.List;
import java.util.Deque;
import java.util.ArrayDeque;

public class Question841{
    public boolean canVisitAllRooms(List<List<Integer>> rooms)
    {
        int n = rooms.size();
        boolean[] visited = new boolean[n];

        int numVisited = 0;
        visited[0] = true;
        numVisited = 1;
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        queue.offer(0);
        while(queue.size() != 0)
        {   
            int room = queue.poll();
            List<Integer> keys = rooms.get(room);
            for(Integer key : keys)
            {
                if(visited[key] == false)
                {
                    visited[key] = true;
                    numVisited += 1;
                    queue.offer(key);
                }
            }
      
        }

        return n == numVisited;
    }
}
