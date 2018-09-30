import java.util.ArrayDeque;

public class Question224{
    //7.55 - 8.11, 17mins
    public int calculate(String s) { 
        ArrayDeque<Character> queue = new ArrayDeque<>();
        for(char c : s.toCharArray()){
            if(c == ' ') continue;   
            queue.offer(c);             
        }                               
        return helper(queue);           
    }                                   

    private int helper(ArrayDeque<Character> queue){
        int result = 0;                 
        int sign = 1;                   
        while(queue.size() > 0){        
            char c = queue.peek();   
            if(c == '+' || c == '-'){
                queue.poll();           
                sign = c == '+'?1:-1;
            }                           
            else if(c == '('){          
                queue.poll();           
                result += sign * helper(queue);
            }                           
            else if(c == ')'){
                queue.poll();
                return result;          
            }                           
            else{                       
                StringBuilder sb = new StringBuilder();            
                while(queue.size() > 0 && queue.peek() >= '0' && queue.peek()<='9'){
                    sb.append(queue.poll());
                }                       
                result += sign * Integer.parseInt(sb.toString()); 
            }                           
        }                               
        return result;                  
    }
}
