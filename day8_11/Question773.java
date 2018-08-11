import java.util.HashSet;
import java.util.ArrayDeque;

public class Question773{
    public int slidingPuzzle(int[][] board) {
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        HashSet<String> set = new HashSet<>();
        int[][] pos = {{1, 3}, {0, 4, 2}, {1, 5}, {0, 4}, {1, 3, 5}, {2, 4}};
        int[] state = new int[6];             
        for(int i = 0;i<6;i++) state[i] = board[i/3][i%3];
        queue.offer(state);                   
        int step = 0;                         
        while(queue.size() != 0){             
            int len = queue.size();           
            for(int j = 0;j<len;j++){         
                int[] tmp = queue.poll();  
                String tmpString = getKey(tmp);
                if(set.contains(tmpString)) continue;
                set.add(tmpString);           
                if(check(tmp)) return step;                                                                                                                                                                 
                int tmpIndex = getIndex(tmp);
                for(int i = 0;i<pos[tmpIndex].length;i++){
                    int[] newState = tmp.clone();
                    swap(newState, tmpIndex, pos[tmpIndex][i]);
                    queue.offer(newState); 
                }                             
            }                                 
            step += 1;                        
        }                                     
        return -1;                            
    }         

    private boolean check(int[] state){   
        for(int i = 0;i<5;i++){           
            if(state[i] != i+1)           
                return false;             
        }                                 
        return true;                      
    }                                     

    private void swap(int[] state, int index1, int index2){
        int tmp = state[index1];          
        state[index1] = state[index2];    
        state[index2] = tmp;              
    }

    private int getIndex(int[] state){
        for(int i = 0;i<6;i++){
            if(state[i] == 0)
                return i;
        }
        return -1;
    }
    private String getKey(int[] state){
        StringBuilder sb = new StringBuilder();
        for(int i = 0;i<state.length;i++) sb.append(state[i]);
        return sb.toString();
    }

}
