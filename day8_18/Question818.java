import java.util.HashMap;

public class Question818{
    HashMap<Integer, Integer> map = new HashMap<>();
    public int racecar(int target) {
        map.put(1, 1);
        return helper(target);
    }

    private int helper(int target) {
        if (map.containsKey(target)) return map.get(target);
        int speed = 1;
        int cur = 0;
        int step = 0;
        while (cur + speed < target) {
            cur = cur + speed;
            speed *= 2;
            step += 1;
        }
        if (cur + speed != target) {
            int tmpStep = step + 1;
            step = helper(cur + speed - target) + step + 2;
            int tmpSpeed = 1;
            while (cur > 0) {
                step = Math.min(step, tmpStep + 1 + helper(target - cur));
                cur -= tmpSpeed;
                tmpSpeed *= 2;
                tmpStep += 1;
            }
        } else step += 1;
        map.put(target, step);
        return step;
    }
}
