class HitCounter {
    int[] times = new int[300];
    int[] count = new int[300];
    /** Initialize your data structure here. */
    public HitCounter() {
        
    }

    /** Record a hit.
      @param timestamp - The current timestamp (in seconds granularity). */
    public void hit(int timestamp) {
        int index = timestamp % 300;
        if(times[index] == timestamp){
            count[index] += 1;
        }
        else{
            times[index] = timestamp;
            count[index] = 1;
        }
    }

    /** Return the number of hits in the past 5 minutes.
      @param timestamp - The current timestamp (in seconds granularity). */
    public int getHits(int timestamp) {
        int res = 0;
        for(int i = 0;i<count.length;i++){
            if(Math.abs(times[i] - timestamp) < 300)
                res += count[i];
        }
        return res;
    }
}
