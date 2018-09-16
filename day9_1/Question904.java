import java.util.HashMap;

public class Question904{
    public int totalFruit(int[] tree) {
        int result = 0;
        HashMap<Integer, Integer> count = new HashMap<>();
        int unique = 0;
        int left = 0;
        int right = 0;
        while(right < tree.length){
            int curNum = tree[right];
            int leftNum = tree[left];
            if(unique < 2 || unique == 2 && count.getOrDefault(curNum, 0) != 0){
                if(!count.containsKey(curNum) || count.get(curNum) == 0) unique += 1;
                count.put(curNum, count.getOrDefault(curNum, 0) + 1);
                right += 1;
                result = Math.max(result, right-left);
            }
            else{
                if(count.get(leftNum) == 1) unique -= 1;
                count.put(leftNum, count.get(leftNum)-1);
                left += 1;
            }
        }
        return result;
    }
}
