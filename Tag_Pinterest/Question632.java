import java.util.PriorityQueue;
import java.util.Comparator;
import java.util.List;
public class Question632{
    public int[] smallestRange(List<List<Integer>> nums) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>(){
            @Override
            public int compare(int[] i1, int[] i2){
                return nums.get(i1[0]).get(i1[1]) - nums.get(i2[0]).get(i2[1]);
            }
        });

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for(int i = 0;i<nums.size();i++){
            int num = nums.get(i).get(0);
            max = Math.max(max, num);
            min = Math.min(min, num);
            pq.offer(new int[]{i, 0});
        }
        int[] result = new int[]{min, max};
        int minRange = max - min;
        while(pq.size() == nums.size()){
            int[] tmp = pq.poll();
            if(tmp[1] == nums.get(tmp[0]).size()-1) continue;
            int tmpNum = nums.get(tmp[0]).get(tmp[1]+1);
            tmp[1] += 1;
            pq.offer(tmp);
            max = Math.max(max, tmpNum);
            min = nums.get(pq.peek()[0]).get(pq.peek()[1]);
            if(minRange > max - min){
                minRange = max - min;
                result[0] = min;
                result[1] = max;
            }
        }
        return result;
    }
}
