import java.util.HashMap;

public class Question423{
    public String originalDigits(String s) {
        char[] c = s.toCharArray();
        HashMap<Character, Integer> map = new HashMap<>();
        HashMap<Integer, Integer> result = new HashMap<>();
        for(char ch : c){
            switch(ch){
                case 'w':
                    result.put(2, result.getOrDefault(2, 0) + 1);
                    map.put('t', map.getOrDefault('t', 0)-1);
                    map.put('o', map.getOrDefault('o', 0)-1);
                    break;
                case 'u':
                    result.put(4, result.getOrDefault(4, 0) + 1);
                    map.put('f', map.getOrDefault('f', 0)-1);
                    map.put('o', map.getOrDefault('o', 0)-1);
                    map.put('r', map.getOrDefault('r', 0)-1);
                    break;
                case 'x':
                    result.put(6, result.getOrDefault(6, 0) + 1);
                    map.put('s', map.getOrDefault('s', 0)-1);
                    map.put('i', map.getOrDefault('i', 0)-1);
                    break;
                case 'g':
                    result.put(8, result.getOrDefault(8, 0) + 1);
                    map.put('e', map.getOrDefault('e', 0)-1);
                    map.put('i', map.getOrDefault('i', 0)-1);
                    map.put('h', map.getOrDefault('h', 0)-1);
                    map.put('t', map.getOrDefault('t', 0)-1);
                    break;
                case 'z':
                    result.put(0, result.getOrDefault(0, 0) + 1);
                    map.put('e', map.getOrDefault('e', 0)-1);
                    map.put('o', map.getOrDefault('o', 0)-1);
                    map.put('r', map.getOrDefault('r', 0)-1);
                    break;
                default:
                    map.put(ch, map.getOrDefault(ch, 0)+1);
                    break;
            }
        }
        if(map.getOrDefault('o', 0) != 0){
            int count = map.get('o');
            result.put(1, result.getOrDefault(1, 0) + count);
            map.put('e', map.get('e')-count);
            map.put('o', map.get('o')-count);
            map.put('n', map.get('n')-count);
        }
        if(map.getOrDefault('h', 0) != 0){
            int count = map.get('h');
            result.put(3, result.getOrDefault(3, 0) + count);
            map.put('t', map.getOrDefault('t', 0)-count);
            map.put('h', map.getOrDefault('h', 0)-count);
            map.put('r', map.getOrDefault('r', 0)-count);
            map.put('e', map.getOrDefault('e', 0)-2*count);
        }
        if(map.getOrDefault('f', 0) != 0){
            int count = map.get('f');
            result.put(5, result.getOrDefault(5, 0) + count);
            map.put('e', map.get('e')-count);
            map.put('i', map.get('i')-count);
            map.put('v', map.get('v')-count);
            map.put('f', map.get('f')-count);
        }
        if(map.getOrDefault('s', 0) != 0){
            int count = map.get('s');
            result.put(7, result.getOrDefault(7, 0) + count);
            map.put('e', map.get('e')-2 * count);
            map.put('s', map.get('e')-count);
            map.put('n', map.get('n')-count);
            map.put('v', map.get('v')-count);
        }
        if(map.getOrDefault('i', 0) != 0){
            int count = map.get('i');
            result.put(9, result.getOrDefault(9, 0) + count);
            map.put('e', map.get('e')-count);
            map.put('i', map.get('i')-count);
            map.put('n', map.get('n')-2*count);
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0;i<=9;i++){
            if(!result.containsKey(i))
                continue;
            for(int j = 0;j<result.get(i);j++)
                sb.append(i);
        }
        return sb.toString();
    }
}
