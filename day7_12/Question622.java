class MyCircularQueue {

    private int[] data;

    private int cur = -1;
    private int tail = 0;


    /** Initialize your data structure here. Set the size of the queue to be k. */
    public MyCircularQueue(int k) {
        if(k <= 0){
            throw new IllegalArgumentException("size is not valid");
        }
        data = new int[k];

    }

    /** Insert an element into the circular queue. Return true if the operation is successful. */
    public boolean enQueue(int value) {
        if(tail == cur){
            return false;
        }
        data[tail] = value;
        if(cur == -1){
            cur = tail;
        }
        tail++;
        if(tail == data.length){
            tail = 0;
        }
        return true;
    }

    /** Delete an element from the circular queue. Return true if the operation is successful. */
    public boolean deQueue() {
        if(cur<0){
            return false;
        }
        data[cur] = 0;
        cur++;
        if(cur == data.length){
            cur = 0;
        }
        //empty
        if(cur == tail){
            cur = -1;
        }

        return true;
    }

    /** Get the front item from the queue. */
    public int Front() {
        if(cur>-1){
            return data[cur];
        }
        return -1;
    }

    /** Get the last item from the queue. */
    public int Rear() {
        if(cur>-1){
            return data[tail==0?data.length-1:tail-1];
        }
        return -1;
    }

    /** Checks whether the circular queue is empty or not. */
    public boolean isEmpty() {
        return cur < 0;
    }

    /** Checks whether the circular queue is full or not. */
    public boolean isFull() {
        return cur == tail;
    }
}

