import java.util.List;
import java.util.ArrayList;
import java.util.ArrayDeque;

public class Question224{
    public int calculate(String s) {
        ArrayDeque<String> operator = new ArrayDeque<>();
        ArrayDeque<Integer> operand = new ArrayDeque<>();
        List<String> tokens = parse(s);
        boolean tag = false;
        for(int i = 0;i<tokens.size();i++){
            String token = tokens.get(i);
            if(token.equals("+") || token.equals("-")) operator.push(token);
            else if(token.equals("(")) tag = false;
            else if(token.equals(")")){
                if(operator.size() != 0){
                    int num2 = operand.pop();
                    int num1 = operand.pop();
                    String op = operator.pop();
                    int res = op.equals("+")?num2 + num1:num1-num2;
                    operand.push(res);
                }
            }     
            else{ 
                int num = Integer.parseInt(token);
                if(!tag){
                    tag = true;
                    operand.push(num);
                } 
                else{
                    int num1 = operand.pop();
                    String op = operator.pop();
                    int res = op.equals("+")?num1 + num:num1-num;
                    operand.push(res);
                } 
            }     
        }         
        return operand.pop();
    }             
    private List<String> parse(String s){
        List<String> tokens = new ArrayList<String>();
        char[] chars = s.toCharArray();
        int index = 0;
        while(index < chars.length){
            if(chars[index] == ' '){
                index += 1;
                continue;
            }    
            char c = chars[index];
            if(c == '+' || c == '-' || c == '(' || c == ')'){
                index += 1;
                tokens.add(""+c);
                continue;
            }    
            String num = "" + c;
            while(index+1 < chars.length && chars[index+1] >= '0' && chars[index+1] <= '9'){
                index += 1;
                num += chars[index];
            }    
            index += 1;
            tokens.add(num);
        }        
        return tokens;
    }
}
