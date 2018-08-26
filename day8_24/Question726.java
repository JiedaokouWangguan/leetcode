public class Question726{
    public String countOfAtoms(String formula) {
        ArrayDeque<Character> queue = new ArrayDeque<>();
        queue.offer('(');
        for(char c : formula.toCharArray()) queue.offer(c);
        queue.offer(')');
        TreeMap<String, Integer> map = helper(queue);
        StringBuilder sb = new StringBuilder();
        for (String key : map.keySet()){
            int count = map.get(key);
            sb.append(key);
            if(count > 1) sb.append(count);
        }
        return sb.toString();
    }

    private TreeMap<String, Integer> helper(ArrayDeque<Character> queue){
        TreeMap<String, Integer> map = new TreeMap<>();
        queue.poll();
        String lastKey = "";
        while(queue.size() != 0 && queue.peek() != ')'){
            char tmp = queue.peek();
            if(tmp == '('){
                TreeMap<String, Integer> m = helper(queue);
                for (String k : m.keySet()) map.put(k, map.getOrDefault(k, 0) + m.get(k));
            }
            else if(tmp >= '0' && tmp <= '9'){
                int carry = 0;
                while(queue.size() > 0 && queue.peek() >= '0' && queue.peek() <= '9')
                    carry = carry * 10 + (queue.poll() - '0');
                carry -= 1;
                map.put(lastKey, map.get(lastKey) + carry);
            }
            else{
                lastKey = "";
                boolean tag = true;
                while(queue.size() > 0 && (queue.peek() >= 'A' && queue.peek() <= 'Z' && tag || queue.peek() >= 'a' && queue.peek() <= 'z')){
                    char tmpAl = queue.poll();
                    if(tmpAl >= 'A' && tmpAl <= 'Z') tag = false;
                    lastKey += tmpAl;
                }
                map.put(lastKey, map.getOrDefault(lastKey, 0) + 1);
            }
        }
        queue.poll();
        int carry = 0;
        while(queue.size() > 0 && queue.peek() >= '0' && queue.peek() <= '9')
            carry = carry * 10 + (queue.poll() - '0');
        if(carry != 0){
            for (String key : map.keySet())
                map.put(key, map.get(key) * carry);
        }
        return map;
    }
}