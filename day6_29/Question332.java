import java.util.List;
import java.util.PriorityQueue;
import java.util.LinkedList;
import java.util.Map;
import java.util.HashMap;

public class Question332{
    Map<String, PriorityQueue<String>> targets = new HashMap<>();
    List<String> route = new LinkedList<>();
    public List<String> findItinerary(String[][] tickets) {
        for (String[] ticket : tickets){
            PriorityQueue<String> pq = targets.getOrDefault(ticket[0], new PriorityQueue<String>());
            pq.add(ticket[1]);
            targets.put(ticket[0], pq);
        }
        visit("JFK");
        return route;
    }
    void visit(String airport) {
        while(targets.containsKey(airport) && !targets.get(airport).isEmpty())
            visit(targets.get(airport).poll());
        route.add(0, airport);
    }
}
