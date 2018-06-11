import java.util.List;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Arrays;
import java.util.Comparator;

public class Question632{
    public int[] smallestRange(List<List<Integer>> nums){
        PriorityQueue<Element> pq = new PriorityQueue<Element>(new Comparator<Element>(){
            @Override
            public int compare(Element a, Element b){
                return a.val - b.val;
            }
        });

        int tmpMax = Integer.MIN_VALUE;
        int tmpMin = 0;
        int max = 0;
        int min = 0;
        int range = Integer.MAX_VALUE;
        for(int i = 0;i<nums.size();i++){
            int tmpNum = nums.get(i).get(0);
            pq.offer(new Element(i, 0, tmpNum));
            tmpMax = Math.max(tmpMax, tmpNum);
        }
        while(pq.size() == nums.size()){
            Element e = pq.poll();
            if(tmpMax - e.val < range){
                range = tmpMax - e.val;
                min = e.val;
                max = tmpMax;
            }
            if(e.col < nums.get(e.row).size()-1){
                e.col = e.col + 1;
                e.val = nums.get(e.row).get(e.col);
                tmpMax = Math.max(tmpMax, e.val);
                pq.offer(e);
            }
        }
        return new int[]{min, max};
    }
}

class Element{
    int row;
    int col;
    int val;
    public Element(int r, int c, int v){
        row = r;
        col = c;
        val = v;
    }
}
