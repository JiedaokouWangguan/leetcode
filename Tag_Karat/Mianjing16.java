import java.util.PriorityQueue;
import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;

// time complexity is O(nlogK) where n is the number of pictures and k is the number of columns
// time complexity is O(nMax(logk1,logk2))

public class Mianjing16{
    public List<List<Picture>> fuckthisshit(int col, List<Picture> imgs){
        PriorityQueue<Column> pq = new PriorityQueue<Column>(new Comparator<Column>(){
            @Override
            public int compare(Column c1, Column c2){
                return c1.height - c2.height;
            }
        });
        for(int i = 0;i<col;i++){
            pq.offer(new Column(i, 0));
        }
        List<List<Picture>> result = new ArrayList<>(col);
        for(int i = 0;i<col;i++){
            result.add(new ArrayList<>());
        }
        for(int i = 0;i<imgs.size();i++){
            Picture img = imgs.get(i);
            Column c = pq.poll();
            c.height += img.height;
            result.get(c.id).add(img);
            pq.offer(c);
        }
        return result;
    }

    public List<List<Integer>> slaythatbitch(int newCol, int oldCol, List<List<Picture>> oldLayout){
        List<List<Integer>> result = new ArrayList<>();
        for(int i = 0;i<newCol;i++){
            result.add(new ArrayList<Integer>());
        }
        PriorityQueue<Column> pq1 = new PriorityQueue<>(new Comparator<Column>(){
            @Override
            public int compare(Column c1, Column c2){
                return c1.height - c2.height;
            }
        });
        for(int i = 0;i<newCol;i++){
            pq1.offer(new Column(i, 0));
        }

        PriorityQueue<Picture> pq2 = new PriorityQueue<>(new Comparator<Picture>(){
            @Override
            public int compare(Picture p1, Picture p2){
                return p2.priority - p1.priority;
            }
        });

        for(int i = 0; i < oldCol;i++){
            List<Picture> list = oldLayout.get(i);
            pq2.offer(list.remove(0));
        }

        while(pq2.size() > 0){
            Picture img = pq2.poll();
            if(oldLayout.get(img.id).size() > 0) pq2.offer(oldLayout.get(img.id).remove(0));
            Column c = pq1.poll();
            c.height += img.height;
            result.get(c.id).add(img.id);
            pq1.offer(c);
        }
        return result;
    }
}

class Column{
    int id;
    int height;
    public Column(int id, int height){
        this.id = id;
        this.height = height;
    }
}

class Picture{
    int id;
    int priority;
    int height;
    public Picture(int id, int height){
        this.id = id;
        this.height=height;
    }
}
