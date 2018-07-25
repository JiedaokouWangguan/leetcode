import java.util.PriorityQueue;
import java.util.Comparator;

public class Question875{
    public int minEatingSpeed(int[] piles, int H) {
        Arrays.sort(piles);
        long total = 0;
        for(int pile : piles) total += pile;
        int min = (int)Math.ceil(total/(double)H);
        int max = piles[piles.length - 1];
        while (min < max){
            if (canFinish(piles, min, H)) return min;
            if (canFinish(piles, (min + max) / 2, H)) max = (min + max)/2;
            else min = (min + max) / 2 + 1;
        }
        return (int)min;
    }


    private boolean canFinish(int[] piles, int speed, int target){
        long counter = 0;
        for (int pile : piles){
            counter += Math.ceil(pile / (double)speed);
        }
        return (int)counter <= target;
    }
}

