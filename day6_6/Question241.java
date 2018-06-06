import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;

public class Question241{
    HashMap<String, List<Integer>> map = new HashMap<>();
    public List<Integer> diffWaysToCompute(String input){
        return helper(input);
    }

    private List<Integer> helper(String input){
        if(map.containsKey(input))
            return map.get(input);

        List<Integer> list = new ArrayList<>();
        for(int i = 0;i<input.length();i++){
            char c = input.charAt(i);
            if(c == '+' || c == '-' || c == '*'){
                List<Integer> term1 = helper(input.substring(0, i));
                List<Integer> term2 = helper(input.substring(i+1, input.length()));
                for(int t1 = 0;t1<term1.size();t1++){
                    for(int t2 = 0;t2<term2.size();t2++){
                        if(c == '+'){
                            list.add(term1.get(t1) + term2.get(t2));
                        }
                        else if(c == '-'){
                            list.add(term1.get(t1) - term2.get(t2));
                        }
                        else{
                            list.add(term1.get(t1) * term2.get(t2));
                        }
                    }
                }
            }
        }
        if(list.size() == 0)
            list.add(Integer.parseInt(input));
        map.put(input, list);
        return list;
    }

}
