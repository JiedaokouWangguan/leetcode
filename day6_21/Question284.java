import java.util.Iterator;

class PeekingIterator implements Iterator<Integer> {
    
    Iterator<Integer> i;
    Integer cur = null;
    public PeekingIterator(Iterator<Integer> iterator) {
        i = iterator;
        if(i.hasNext())
            cur = i.next();
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        return cur;
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
        int tmp = cur;
        if(i.hasNext())
            cur = i.next();
        else
            cur = null;
        return tmp;
    }

    @Override
    public boolean hasNext() {
        return cur != null;
    }
}
