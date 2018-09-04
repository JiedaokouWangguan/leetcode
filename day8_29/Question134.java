package leetcode.day8_29;

public class Question134 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int begin = gas.length - 1;
        int end = 0;
        int sum = gas[begin] - cost[begin];
        while (end < begin){
            if (sum >= 0){
                sum += gas[end] - cost[end];
                end += 1;
            }
            else{
                begin -= 1;
                sum += gas[begin] - cost[begin];
            }
        }
        return sum >= 0?begin : -1;
    }
}
