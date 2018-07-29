public class Question754{
    public int reachNumber(int target) {
        if(target < 0) target *= -1;
        int sum = 0;
        int i = 1;
        for(;sum < target;i++) sum += i;
        i -= 1;
        if(sum == target || (sum - target)%2 == 0) return i;
        i += 1;
        for(;(sum + i - target)%2 == 1;i++);
        return i;
    }
}
