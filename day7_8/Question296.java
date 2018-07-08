public class Question296{
    public int minTotalDistance(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int[] rowCount = new int[rows];
        int[] colCount = new int[cols];
        for(int row = 0;row < rows;row++){
            for(int col = 0;col<cols;col++){
                if(grid[row][col] == 1){
                    rowCount[row] += 1;
                    colCount[col] += 1;
                }
            }
        }
        return getDist(rowCount) + getDist(colCount);
    }

    private int getDist(int[] count){
        int left = 0;
        int right = count.length-1;
        int result = 0;
        int leftAmount = 0;
        int rightAmount = 0;
        while(leftAmount < rightAmount){
            if(leftAmount < rightAmount){
                result += leftAmount;
                leftAmount += count[left++];
            }
            else{
                result += rightAmount;
                rightAmount += count[right--];
            }
        }
        return result;
    }
}
