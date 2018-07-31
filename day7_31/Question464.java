import java.util.HashMap;

public class Question464{
    HashMap<Integer, Boolean> map = new HashMap<Integer, Boolean>();
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        int sum = (1+maxChoosableInteger)*maxChoosableInteger/2;
        if(sum < desiredTotal) return false;
        if(desiredTotal <= 0) return true;
        return guaWin(new boolean[maxChoosableInteger+1], desiredTotal);
    }                

    private boolean guaWin(boolean[] visited, int target){
        if(target <= 0) return false;
        int key = getKey(visited);
        if(map.containsKey(key)) return map.get(key);
        for(int i = 1;i< visited.length;i++){
            if(visited[i]) continue;
            visited[i] = true;
            boolean res = guaWin(visited, target - i);
            if(!res){
                map.put(key, true);
                visited[i] = false;
                return true;
            }        
            visited[i] = false;
        }            
        map.put(key, false);
        return false;                                                                                                      
    }                

    private int getKey(boolean[] visited){
        int num = 0;
        for(boolean b: visited){
            num <<= 1;
            if(b) num |= 1;
        }
        return num;
    }                

}
