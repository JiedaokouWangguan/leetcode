import java.util.HashMap;

public class Question464{
    HashMap<Integer, Boolean> map = new HashMap<>();
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) { 
        if(((1+maxChoosableInteger)*maxChoosableInteger/2) < desiredTotal) return false;
        if(desiredTotal <= 0) return true;
        boolean[] visited = new boolean[maxChoosableInteger+1];
        return dp(desiredTotal, 0, visited);
    }                                 

    private boolean dp(int target, int cur, boolean[] visited){
        if(cur >= target) return false;
        int key = getKey(visited);    
        if(map.containsKey(key)) return map.get(key);
        boolean result = false;       
        for(int i = 1;i<visited.length;i++){
            if(visited[i]) continue;  
            visited[i] = true;        
            if(!dp(target, cur+i, visited)) result = true;                                
            visited[i] = false;       
            if(result) break;         
        }                             
        map.put(key, result);                                                             
        return result;                
    }                                 

    private int getKey(boolean[] visited){  
        int result = 0;               
        for(int i = 0;i<visited.length;i++){
            result <<= 1;             
            if(visited[i]) result |= 1;  
        }                             
        return result;                
    }  
}
