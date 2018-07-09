import java.util.ArrayDeque;
import java.util.HashSet;

public class Question865{
    public int shortestPathAllKeys(String[] grid) {
        int x = 0;
        int y = 0;
        int numKey = -1;
        int rows = grid.length;
        int cols = grid[0].length();
        for(int row = 0;row < rows; row++){
            for(int col = 0;col < cols;col++){
                char c = grid[row].charAt(col);
                if(c == '@'){
                    x = row;
                    y = col;
                }
                else if(c >= 'a' && c <= 'f'){
                    numKey = Math.max(numKey, c-'a'+1);
                }
            }
        }
        
        HashSet<String> visited = new HashSet<>();
        ArrayDeque<State> queue = new ArrayDeque<>();
        visited.add(0+" "+x+" "+y);
        queue.offer(new State(x, y, 0));
        int[] delta = {0, 1, 0, -1, 0};
        int step = 0;
        while(queue.size() != 0){
            int len = queue.size();
            for(int i = 0;i<len;i++){
                State tmp = queue.poll();
                if(tmp.key == (1 << numKey) -1) return step;
                for(int j = 0;j<4;j++){
                    int newRow = tmp.row + delta[j];
                    int newCol = tmp.col + delta[j+1];
                    int keys = tmp.key;
                    if(newRow >= 0 && newRow < rows && newCol >=0 && newCol < cols){
                        char cur = grid[newRow].charAt(newCol);
                        if(cur == '#') continue;
                        if(cur >= 'a' && cur <= 'f') keys |= (1 << (cur-'a'));
                        if(cur >= 'A' && cur <= 'F' && ((keys >> (cur - 'A')) & 1) == 0) continue;
                        if(!visited.contains(keys +" " +newRow + " " +newCol)){
                            visited.add(keys+" "+newRow+" "+newCol);
                            queue.offer(new State(newRow, newCol, keys));
                        }
                    }
                }
            }
            step += 1;
        }
        return -1;
    }
}

class State{
    int row;
    int col;
    int key;
    public State(int a, int b, int c){
        row = a;
        col = b;
        key = c;
    }
}


