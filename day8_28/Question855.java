package leetcode.day8_28;

import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

class ExamRoom {
    int n = 0;
    HashMap<Integer, int[]> begin = new HashMap<>();
    HashMap<Integer, int[]> end = new HashMap<>();
    PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>(){
        @Override
        public int compare(int[] i1, int[] i2){
            int d1 = getDist(i1);
            int d2 = getDist(i2);
            if (d1 == d2) return i1[0] - i2[0];
            return d2 - d1;
        }
    });
    public ExamRoom(int N) {
        int[] cur = new int[]{0, N-1};
        pq.offer(cur);
        begin.put(0, cur);
        end.put(N-1, cur);
        n = N;
    }

    private int getDist(int[] i){
        if (i[0] != 0 && i[1] != n-1) return (i[1] - i[0])/2;
        else return i[1] - i[0];
    }

    public int seat() {
        int[] tmp = pq.poll();
        begin.remove(tmp[0]);
        end.remove(tmp[1]);
        if(tmp[0] == 0){
            if (tmp[1] != 0){
                tmp[0] = 1;
                pq.offer(tmp);
                begin.put(tmp[0], tmp);
                end.put(tmp[1], tmp);
            }
            return 0;
        }
        if(tmp[1] == n-1){
            if(tmp[0] != n-1){
                tmp[1] = n-2;
                pq.offer(tmp);
                begin.put(tmp[0], tmp);
                end.put(tmp[1], tmp);
            }
            return n-1;
        }
        int mid= (tmp[1] + tmp[0])/2;
        if (tmp[0] < mid) {
            int[] endArray = new int[]{tmp[0], mid - 1};
            end.put(mid-1, endArray);
            begin.put(tmp[0], endArray);
            pq.offer(endArray);
        }
        if (tmp[1] > mid){
            int[] beginArray = new int[]{mid + 1, tmp[1]};
            begin.put(mid + 1, beginArray);
            end.put(tmp[1], beginArray);
            pq.offer(beginArray);
        }
        return mid;
    }

    public void leave(int p) {
        int[] tmp = new int[] {p, p};
        if(begin.containsKey(p+1)){
            int[] beginArray = begin.get(p+1);
            pq.remove(beginArray);
            begin.remove(p+1);
            end.remove(beginArray[1]);
            tmp[1] = beginArray[1];
        }
        if(end.containsKey(p-1)){
            int[] endArray = end.get(p-1);
            pq.remove(endArray);
            end.remove(p-1);
            begin.remove(endArray[0]);
            tmp[0] = endArray[0];
        }
        begin.put(tmp[0], tmp);
        end.put(tmp[1], tmp);
        pq.offer(tmp);
    }
}