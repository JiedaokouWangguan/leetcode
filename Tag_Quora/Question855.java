import java.util.PriorityQueue;
import java.util.HashMap;
import java.util.Comparator;

// 1.25
class ExamRoom {
    int n = 0;
    PriorityQueue<int[]> pq = null;
    private int getDist(int[] i){
        if(i[0] == 0 && i[1] == n-1){
            return i[1] - i[0];
        }
        else{
            return (i[1] - i[0])/2;
        }
    }
    HashMap<Integer, int[]> getByHead = new HashMap<>();
    HashMap<Integer, int[]> getByTail = new HashMap<>();
    public ExamRoom(int N) {
        n = N;
        pq = new PriorityQueue<int[]>(new Comparator<int[]>(){
            @Override
            public int compare(int[] i1, int[] i2){
                int dist1 = getDist(i1);
                int dist2 = getDist(i2);
                if(dist1 == dist2) return i1[0] - i2[0];
                else return dist1 - dist2;
            }
        });
        int[] cur = new int[]{0, n-1};
        pq.offer(cur);
        getByHead.put(0, cur);
        getByTail.put(n-1, cur);
        
    }
    
    public int seat() {
        if(pq.size() == 0) return -1;
        int[] cur = pq.poll();
        getByHead.remove(cur[0]);
        getByTail.remove(cur[1]);
        if(cur[0] == 0){
            if(cur[1] != 0){
                cur[0] = 1;
                pq.offer(cur);
                getByHead.put(1, cur);
                getByTail.put(cur[1], cur);
            }
            return 0;
        }
        else if(cur[1] == n-1){
            if(cur[0] != n-1){
                cur[1] = n-2;
                pq.offer(cur);
                getByHead.put(cur[0], cur);
                getByTail.put(cur[1], cur);
            }
            return n-1;
        }
        else{
            int mid = (cur[0] + cur[1])/2;
            if(cur[0] <= mid-1){
                int[] tmp = new int[]{cur[0], mid-1};
                pq.offer(tmp);
                getByHead.put(tmp[0], tmp);
                getByTail.put(tmp[1], tmp);
            }
            if(cur[1] >= mid+1){
                int[] tmp = new int[]{mid+1, cur[1]};
                pq.offer(tmp);
                getByHead.put(tmp[0], tmp);
                getByTail.put(tmp[1], tmp);
            }
            return mid;
        }
    }
    
    public void leave(int p) {
        int[] cur = new int[]{p, p};
        if(getByTail.containsKey(p-1)){
            int[] tmp = getByTail.get(p-1);
            getByHead.remove(tmp[0]);
            pq.remove(tmp);
            cur[0] = Math.min(cur[0], tmp[0]);
        }
        if(getByHead.containsKey(p+1)){
            int[] tmp = getByHead.get(p+1);
            getByTail.remove(tmp[1]);
            pq.remove(tmp);
            cur[1] = Math.max(cur[1], tmp[1]);
        }
        getByHead.put(cur[0], cur);
        getByTail.put(cur[1], cur);
        pq.offer(cur);
    }
}
