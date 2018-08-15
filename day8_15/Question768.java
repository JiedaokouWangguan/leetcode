import java.util.PriorityQueue;
import java.util.Comparator;

public class Question768{
    public int maxChunksToSorted(int[] arr) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>(){
            @Override
            public int compare(Integer i1, Integer i2) {
                if (arr[i1] == arr[i2]) return i1 - i2;
                return arr[i1] - arr[i2];
            }
        });
        for(int i = 0;i< arr.length;i++) pq.offer(i);
        int size = 0;
        int maxIndex = -1;
        int result = 0;
        while(pq.size() > 0){
            int curIndex = pq.poll();
            size += 1;
            maxIndex = Math.max(maxIndex, curIndex);
            if(maxIndex + 1 == size) result += 1;
        }
        return result;
    }

    public int maxChunksToSorted1(int[] arr) {
        int n = arr.length;
        int[] maxOfLeft = new int[n];
        int[] minOfRight = new int[n];

        maxOfLeft[0] = arr[0];
        for (int i = 1; i < n; i++) {
            maxOfLeft[i] = Math.max(maxOfLeft[i-1], arr[i]);
        }

        minOfRight[n - 1] = arr[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            minOfRight[i] = Math.min(minOfRight[i + 1], arr[i]);
        }

        int res = 0;
        for (int i = 0; i < n - 1; i++) {
            if (maxOfLeft[i] <= minOfRight[i + 1]) res++;
        }

        return res + 1;
    }
}
