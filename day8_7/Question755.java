import java.util.PriorityQueue;
import java.util.Comparator;

public class Question755{
    public int[] pourWater(int[] heights, int V, int K) {
        PriorityQueue<Integer> left = new PriorityQueue<Integer>(new Comparator<Integer>() {

            @Override
            public int compare(Integer i1, Integer i2) {
                if (heights[i1] == heights[i2]) return i2 - i1;
                return heights[i1] - heights[i2];
            }
        });
        PriorityQueue<Integer> right = new PriorityQueue<Integer>(new Comparator<Integer>() {

            @Override
            public int compare(Integer i1, Integer i2) {
                if (heights[i1] == heights[i2]) return i1 - i2;
                return heights[i1] - heights[i2];
            }
        });
        int indexl = K - 1;
        int indexr = K + 1;
        for (int i = 0; i < V; i++) {
            while (indexl >= 0 && heights[indexl] <= heights[indexl + 1])
                left.offer(indexl--);
            while (indexr < heights.length && heights[indexr] <= heights[indexr - 1])
                right.offer(indexr++);
            if (left.size() > 0 && heights[left.peek()] < heights[K]) {
                int index = left.poll();
                heights[index] += 1;
                left.offer(index);
            } else if (right.size() > 0 && heights[right.peek()] < heights[K]) {
                int index = right.poll();
                heights[index] += 1;
                right.offer(index);
            } else {
                heights[K] += 1;
            }
        }
        return heights;
    }
}
