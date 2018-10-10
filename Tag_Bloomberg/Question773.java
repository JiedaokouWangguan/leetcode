import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.HashMap;

public class Question773{
    HashMap<Integer, int[]> map = new HashMap<>();
    public int slidingPuzzle(int[][] board) {
        map.put(0, new int[]{1, 3});
        map.put(1, new int[]{0, 2, 4});
        map.put(2, new int[]{1, 5});
        map.put(3, new int[]{0, 4});
        map.put(4, new int[]{3, 1, 5});
        map.put(5, new int[]{4, 2});
        String b = "";
        int index = 0;
        for(int i = 0;i<board.length;i++)
            for(int j = 0;j<board[i].length;j++){
                if(board[i][j] == 0) index = i*3 + j;
                b += board[i][j];
            }
        String key = b + "," + index;
        ArrayDeque<String> queue = new ArrayDeque<>();
        queue.offer(key);
        HashSet<String> set = new HashSet<>();
        set.add(b);
        int step = 0;
        while(queue.size() > 0){
            int len = queue.size();
            for(int j = 0;j<len;j++){
                String cur = queue.poll();
                String[] tokens = cur.split(",");
                char[] curStr = tokens[0].toCharArray();
                if(isValid(curStr)) return step;
                index = Integer.parseInt(tokens[1]);
                for(int i : map.get(index)){
                    char tmp = curStr[i];
                    curStr[i] = '0';
                    curStr[index] = tmp;
                    String newStr = new String(curStr);
                    if(!set.contains(newStr)){
                        set.add(newStr);
                        queue.offer(newStr + ","+ i);
                    }
                    curStr[i] = tmp;
                    curStr[index] = '0';
                }
            }
            step += 1;
        }
        return -1;
    }

    private boolean isValid(char[] grid){
        for(int i = 0;i<5;i++){
            if(grid[i] != '1' + i) return false;
        }
        return grid[5] == '0';
    }

}
