import java.util.List;
import java.util.LinkedList;

// Time Complexity and Space complexity are both O(1);
// Because there are only 4 cards, so the total combinations are finite.

public class Mianjing14{
    public boolean game24(int[] num){
        List<Double> list = new LinkedList<>();
        for(int i : num) list.add((double)i);
        return game24(list, 24);
    }

    private boolean game24(List<Double> list, double target){
        if((int)(target) == 18){
            int sadfasdf = 1;
        }
        if(list.size() == 1) return Math.abs(target - list.get(0)) <= 0.0001;
        boolean res = false;
        for(int i = 0;i<list.size();i++){
            double num = list.get(i);
            list.remove(i);
            for(int j = 0;j<4;j++){
                if(j == 0) res |= game24(list, target - num);
                else if(j == 1) res |= game24(list, num - target);
                else if(j == 2) {
                    for(int k = 0;k<list.size();k++){
                        double num1 = list.get(k);
                        list.set(k, num1*num);
                        res |= game24(list, target);
                        list.set(k, num1);
                    }
                }
                else{
                    for(int k = 0;k<list.size();k++){
                        double num1 = list.get(k);
                        list.set(k, num/num1);
                        res |= game24(list, target);
                        list.set(k, num1);
                    }
                }
            }
            list.add(i, num);
        }
        if(res){
            int sdfsd = 1;
        }
        return res;
    }

}
