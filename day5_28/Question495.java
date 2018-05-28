public class Question495{
    public int findPoisonedDuration(int[] timeSeries, int duration){
        int totalDuration = 0;
        int curTime = -1;
        for(int time : timeSeries){
            if(time > curTime){
                curTime = time + duration - 1;
                totalDuration += duration;
            }
            else{
                int diff = curTime + 1 - time;
                if(diff < duration){
                    curTime = time + duration - 1;
                    totalDuration += duration - diff;
                }
            }
        }
        return totalDuration;
    }
}
