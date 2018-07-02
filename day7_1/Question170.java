import java.util.HashSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
class TwoSum {
    HashMap<Integer,Integer> hm;
    TwoSum(){
        hm = new HashMap<Integer,Integer>();
    }
    public void add(int number) {
        if(hm.containsKey(number)){
            hm.put(number,2);
        }else{
            hm.put(number,1);
        }
    }

    public boolean find(int value) {
        Iterator<Integer> iter = hm.keySet().iterator();
        while(iter.hasNext()){
            int num1 = iter.next();
            int num2 = value - num1;
            if(hm.containsKey(num2)){
                if(num1 != num2 || hm.get(num2) == 2){
                    return true;
                }
            }
        }
        return false;
    }
}      

