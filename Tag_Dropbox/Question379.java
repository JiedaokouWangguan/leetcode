import java.util.HashSet;
import java.util.ArrayDeque;

class PhoneDirectory {

    HashSet<Integer> set = new HashSet<>();
    ArrayDeque<Integer> queue = new ArrayDeque<>();
    int remains = 0;

    /** Initialize your data structure here
        @param maxNumbers - The maximum numbers that can be stored in the phone directory. */
    public PhoneDirectory(int maxNumbers) {
        for(int i = 0;i<maxNumbers;i++) queue.offer(i);   
        remains = maxNumbers;
    }
    
    /** Provide a number which is not assigned to anyone.
        @return - Return an available number. Return -1 if none is available. */
    public int get() {
        if(remains == 0) return -1;
        remains -= 1;
        int result = queue.poll();
        set.add(result);
        return result;
    }
    
    /** Check if a number is available or not. */
    public boolean check(int number) {
        return !set.contains(number);
    }
    
    /** Recycle or release a number. */
    public void release(int number) {
        if(!set.contains(number)) return;
        set.remove(number);
        queue.offer(number);
        remains += 1;
    }
}
