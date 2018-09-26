import java.util.ArrayDeque;
import java.util.HashMap;


public class Mianjing6{
    // 11.30-11.55
    // Time complexity is O(N) and space complexity is O(N)
    // 这个题的话是这次面经里比较难的，我个人认为一个不错的方法是用queue+recursion。没有*和/给计算带来了很大的方便
    // 这三个题时间空间都是On，第三个额外多一个map的空间。可以提一下
    
    private int cal1(String s){
        ArrayDeque<Character> queue = new ArrayDeque<>();
        for(char c : s.toCharArray()) queue.offer(c);

        int result = 0;
        int sign = 1;
        while(queue.size() > 0){
            char cur = queue.peek();
            if (cur == '+' || cur == '-'){
                sign = cur == '+'?1:-1;
                queue.poll();
            }
            else if(cur >= '0' && cur <= '9'){
                int number = 0;
                while(queue.size() > 0 && queue.peek() >= '0' && queue.peek() <= '9'){
                    number = number * 10 + (queue.poll() - '0');
                }
                result += sign * number;
            }
        }
        return result;
    }
    // 11.33

    private int cal2(String s){
        ArrayDeque<Character> queue = new ArrayDeque<>();
        for(char c : s.toCharArray()) queue.offer(c);
        return calBlock(queue);
    }

    private int calBlock(ArrayDeque<Character> queue){
        int result = 0;
        int sign = 1;
        while (queue.size() > 0){
            char cur = queue.peek();
            if (cur == '+' || cur == '-'){
                sign = cur == '+'?1:-1;
                queue.poll();
            }
            else if(cur >= '0' && cur <= '9'){
                int number = 0;
                while(queue.size() > 0 && queue.peek() >= '0' && queue.peek() <= '9'){
                    number = number * 10 + (queue.poll() - '0');
                }
                result += sign * number;
            }
            else if(cur == '('){
                queue.poll();
                int number = calBlock(queue);
                result += sign * number;
            }
            else if(queue.peek() == ')'){
                queue.poll();
                return result;
            }
        }
        return result;
    }
    // 11.42


    private String cal3(String s, HashMap<String, Integer> map){
        ArrayDeque<Character> queue = new ArrayDeque<>();
        for(char c : s.toCharArray()) queue.offer(c);
        HashMap<String, Integer> remain = new HashMap<>();
        int result = calBlock3(queue, map, remain);
        StringBuilder sb = new StringBuilder();
        sb.append(result);
        for (String key : remain.keySet()){
            if(remain.get(key) == 1) sb.append("+"+key);
            else if(remain.get(key) == -1) sb.append("-"+key);
            else if(remain.get(key) > 0) sb.append("+"+remain.get(key)+key);
            else sb.append("-" +remain.get(key) + key);
        }
        return sb.toString();
    }

    private int calBlock3(ArrayDeque<Character> queue, HashMap<String, Integer> map, HashMap<String, Integer> remain){
        int result = 0;
        int sign = 1;
        while (queue.size() > 0){
            char cur = queue.peek();
            if (cur == '+' || cur == '-'){
                sign = cur == '+'?1:-1;
                queue.poll();
            }
            else if(cur >= '0' && cur <= '9'){
                int number = 0;
                while(queue.size() > 0 && queue.peek() >= '0' && queue.peek() <= '9'){
                    number = number * 10 + (queue.poll() - '0');
                }
                result += sign * number;
            }
            else if(cur == '('){
                queue.poll();
                int number = calBlock3(queue, map, remain);
                result += sign * number;
            }
            else if(cur == ')'){
                queue.poll();
                return result;
            }
            else if(cur >= 'a' && cur <= 'z'){
                String varName = "";
                while (queue.size() > 0 && queue.peek() >= 'a' && queue.peek() <= 'z'){
                    varName = varName + queue.poll();
                }
                if(map.containsKey(varName)){
                    result += sign * map.get(varName);
                }
                else{
                    remain.put(varName, remain.getOrDefault(varName, 0) + sign);
                }
            }
        }
        return result;
    }

}
