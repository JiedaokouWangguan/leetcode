public class Question59{
    public int[][] generateMatrix(int n){
        int rowBegin = 0;
        int colBegin = 0;
        int rowEnd = n-1;
        int colEnd = n-1;
        int[][] result = new int[n][n];
        int cur = 1;
        while(true){
            if(cur > n*n)
                break;
            for(int i = colBegin;i<=colEnd;i++){
                result[rowBegin][i] = cur++;
            }
            rowBegin++;
            for(int i = rowBegin;i<=rowEnd;i++){
                result[i][colEnd] = cur++;
            }
            colEnd--;
            for(int i = colEnd ;i >=colBegin;i--){
                result[rowEnd][i] = cur++;
            }
            rowEnd--;
            for(int i = rowEnd;i>=rowBegin;i--){
                result[i][colBegin] = cur++;
            }
            colBegin++;
        }
        return result;
    }
}
