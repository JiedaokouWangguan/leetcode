import java.util.HashSet;
import java.util.HashMap;

public class Question851{
    public int[] loudAndRich(int[][] richer, int[] quiet) {
        HashMap<Integer, Person> map = new HashMap<>();
        for (int[] rich : richer) {
            int indexMore = rich[0];
            int indexLess = rich[1];
            if (!map.containsKey(indexMore)) map.put(indexMore, new Person(indexMore));
            if (!map.containsKey(indexLess)) map.put(indexLess, new Person(indexLess));
            map.get(indexLess).richer.add(map.get(indexMore));
        }
        int[] result = new int[quiet.length];
        for (int index = 0; index < quiet.length; index++) {
            if (!map.containsKey(index)) result[index] = index;
            else result[index] = helper(index, map, quiet);
        }
        return result;
    }

    private int helper(int index, HashMap<Integer, Person> map, int[] quiet) {
        if (map.get(index).answer != -1) return map.get(index).answer;
        if (map.get(index).richer.size() == 1) {
            map.get(index).answer = index;
            return index;
        }
        int resIndex = index;
        int res = quiet[index];
        for (Person p : map.get(index).richer) {
            if (p.index == index) continue;
            int tmpIndex = helper(p.index, map, quiet);
            if (quiet[tmpIndex] < res) {
                resIndex = tmpIndex;
                res = quiet[tmpIndex];
            }
        }
        map.get(index).answer = resIndex;
        return resIndex;
    }
}

class Person{
    HashSet<Person> richer = new HashSet<>();
    int answer = -1;
    int index;
    public Person(int x){
        index = x;
        richer.add(this);
    }
}
