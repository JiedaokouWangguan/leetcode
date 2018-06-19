import java.util.PriorityQueue;
import java.util.Comparator;

public class Question452{
    public int findMinArrowShots(int[][] points) {
        PriorityQueue<Position> pq = new PriorityQueue<>(new Comparator<Position>(){
            @Override
            public int compare(Position p1, Position p2){
                return p1.begin == p2.begin? p2.end - p1.end : p1.begin - p2.begin;
            }
        });
        for(int i = 0;i<points.length;i++){
            Position tmp = new Position(points[i][0], points[i][1]);
            pq.offer(tmp);
        }
        int result = 0;
        while(pq.size() != 0){
            Position tmp = pq.poll();
            int tmpMinEnd = tmp.end;
            while(pq.size() != 0 && pq.peek().begin <= tmpMinEnd){
                Position t = pq.poll();
                tmpMinEnd = Math.min(tmpMinEnd, t.end);
            }
            result += 1;
        }
        return result;
    }
}

class Position{
    int begin;
    int end;
    public Position(int b, int e){
        begin = b;
        end = e;
    }
}
