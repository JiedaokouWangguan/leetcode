public class Question889{
    public int[][] spiralMatrixIII(int R, int C, int r0, int c0) {
        int index = 1;
        int[][] result = new int[R*C][2];
        int len = 1;  
        int curLenCount = 2;
        int direction = 0;
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};  // right, down, left, up

        result[0][0] = r0; 
        result[0][1] = c0; 


        int curRow = r0; 
        int curCol = c0; 
        while(index < R*C){
            if(curLenCount <= 0){ 
                len += 1;
                curLenCount = 2;
            }            
            if(direction == 4) direction = 0;

            for(int i = 0;i<len;i++){
                int newRow = curRow + directions[direction][0];
                int newCol = curCol + directions[direction][1];
                if(newRow >= 0 && newRow < R && newCol >= 0 && newCol < C){ 
                    result[index][0] = newRow;
                    result[index][1] = newCol;
                    index += 1;
                }
                curRow = newRow;
                curCol = newCol;
            }
            direction += 1;
            curLenCount -= 1;
        }                
        return result; 
    }
}
