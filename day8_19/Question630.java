import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Question630{
    public int scheduleCourse(int[][] courses) {
        Arrays.sort(courses, new Comparator<int[]>() {

            @Override
            public int compare(int[] i1, int[] i2) {
                return i1[1] - i2[1];
            }
        });
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {

            @Override
            public int compare(Integer i1, Integer i2) {
                return i2 - i1;
            }
        });

        int curTime = 0;
        for (int i = 0; i < courses.length; i++) {
            int[] cur = courses[i];
            curTime += cur[0];
            pq.offer(cur[0]);
            if (curTime > cur[1]) curTime -= pq.poll();
        }
        return pq.size();
    }
}
