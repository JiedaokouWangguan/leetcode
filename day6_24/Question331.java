import java.util.ArrayDeque;

public class Question331{
    public boolean isValidSerialization(String preorder){         
        String[] ss = preorder.split(",");                        
        ArrayDeque<String> stack = new ArrayDeque<>();            
        stack.push(ss[0]);                                  
        for(int i = 1;i<ss.length;i++){                           
            if(!ss[i].equals("#")){                               
                stack.push(ss[i]);                                
                continue;                                   
            }                                               
            if(stack.size()!=0 && stack.peek().equals("#")){      
                while(stack.size() != 0 && stack.peek().equals("#")){    
                    stack.pop();                                  
                    if(stack.size() == 0 || stack.peek().equals("#"))                  
                        return false;                             
                    stack.pop();                                  
                }                                           
            }                                               
            stack.push(ss[i]);                                    
        }                                                   
        return stack.size() == 1 && stack.peek().equals("#");                                                                                    
    }       
}
