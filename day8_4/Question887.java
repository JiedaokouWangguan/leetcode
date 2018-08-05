public class Question887{
    public int projectionArea(int[][] grid) {        
        return  top(grid) + rowSum(grid) + colSum(grid);             
    }                                                

    private int top(int[][] grid){       
        int sum = 0;  
        for(int row = 0;row < grid.length;row++){                       
            for(int col = 0;col < grid[row].length;col++){
                if(grid[row][col] != 0)
                    sum += 1;
            }                     
        }                                            
        return sum;           
    }                                                

    private int rowSum(int[][] grid){                
        int sum = 0;                                 
        for(int row = 0;row < grid.length;row++){ 
            int tmpMax = 0;                          
            for(int col = 0;col < grid[row].length;col++){
                tmpMax = Math.max(tmpMax, grid[row][col]);
            }                                        
            sum += tmpMax;                           
        }                                            
        return sum;                                  
    }                                                

    private int colSum(int[][] grid){                
        int sum = 0;                                 
        for(int col = 0;col < grid[0].length;col++){
            int tmpMax = 0;                          
            for(int row = 0;row < grid.length;row++){
                tmpMax = Math.max(tmpMax, grid[row][col]);                                                                                                                                 
            }                                        
            sum += tmpMax;                           
        }                                            
        return sum;                                  
    }
}
