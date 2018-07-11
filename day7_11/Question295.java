import java.util.PriorityQueue;
import java.util.Comparator;

class MedianFinder {
    /** initialize your data structure here. */

    PriorityQueue<Integer> min = new PriorityQueue<>();
    PriorityQueue<Integer> max = new PriorityQueue<>(new Comparator<Integer>(){
        @Override
        public int compare(Integer i1, Integer i2){
            return i2 - i1;
        }
    });
    
    public MedianFinder() {

    }

    public void addNum(int num) {
        if(min.size() == 0 || min.peek() <= num) min.offer(num);
        else max.offer(num);
        while(min.size() - max.size() > 1) max.offer(min.poll());
        while(max.size() - min.size() > 1) min.offer(max.poll());
    }

    public double findMedian() {
        if(min.size() > max.size()) return min.peek();
        else if(min.size() < max.size()) return max.peek();
        else return (min.peek() + max.peek()) * 1.0 / 2;
    }
}
