import java.util.ArrayList;
import java.util.List;
import java.util.ArrayDeque;
import java.util.HashMap;

public class Question224{
    public int calculate(String s) {
        ArrayDeque<Long> operands = new ArrayDeque<>();
        ArrayDeque<String> operators = new ArrayDeque<>();
        HashMap<String, Integer> priority = new HashMap<>();
        priority.put("+", 1);
        priority.put("-", 1);
        priority.put("*", 2);
        priority.put("/", 2);
        priority.put("(", 0);
        priority.put(")", 3);

        List<String> tokens = parse(s);
        for(String token : tokens){
            if(isNum(token)){
                operands.push(Long.parseLong(token));
            }
            else{
                int p = priority.get(token);
                if(p == 0) operators.push(token);
                else if(p == 1 || p == 2){
                    while(operators.size() > 0 && priority.get(operators.peek()) >= p){
                        calculate(operands, operators);
                    }
                    operators.push(token);
                }
                else if(p == 3){
                    while(operators.size() > 0 && !operators.peek().equals("(")){
                        calculate(operands, operators);
                    }
                    operators.pop();
                }
            }
        }
        while(operators.size() > 0) calculate(operands, operators);
        return operands.pop().intValue();
    }
    private void calculate(ArrayDeque<Long> operands, ArrayDeque<String> operators){
        long num2 = operands.pop();
        long num1 = operands.pop();
        String op = operators.pop();
        long result = 0;
        if(op.equals("+")){
            result = num1 + num2;
        }
        else if(op.equals("-")){
            result = num1 - num2;
        }
        else if(op.equals("*")){
            result = num1 * num2;
        }
        else{
            result = num1/num2;
        }
        operands.push(result);
    }

    private boolean isNum(String s){
        if(s.length() > 1 || (s.charAt(0)>='0' && s.charAt(0)<='9' )) return true;
        else return false;
    }

    private List<String> parse(String s){
        int n = s.length();
        int i = 0;
        List<String> result = new ArrayList<>();
        char[] chars = s.toCharArray();
        while(i < n){
            if(chars[i] == ' '){
                i += 1;
                continue;
            }
            if(chars[i] >= '0' && chars[i] <= '9'){
                int index = i;
                while(i < n && chars[i] >= '0' && chars[i] <= '9'){
                    i += 1;
                }
                result.add(s.substring(index, i));
            }
            else{
                result.add(""+chars[i]);
                i += 1;
            }
        }
        return result;
    }
}
