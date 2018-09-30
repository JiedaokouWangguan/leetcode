import java.util.List;
import java.util.ArrayList;

public class Question54{
    // 7.17 - 7.35, 18mins
    public List<Integer> spiralOrder(int[][] matrix) { 
        List<Integer> result = new ArrayList<>();
        if(matrix == null || matrix.length == 0) return result;
        int rows = matrix.length;   
        int cols = matrix[0].length;


        int rowBegin = 0;           
        int rowEnd = rows-1;        
        int colBegin = 0;           
        int colEnd = cols-1;        
        for(int j = 0;j<rows * cols;){                                                                         
            for(int i = colBegin ; i<=colEnd&&j<rows * cols;i++){
                result.add(matrix[rowBegin][i]);
                j++;
            }                       
            rowBegin += 1;          
            for(int i = rowBegin;i <= rowEnd&&j<rows * cols;i++){
                result.add(matrix[i][colEnd]);
                j++;
            }                       
            colEnd -= 1;            
            for(int i = colEnd;i >= colBegin&&j<rows * cols;i--){
                result.add(matrix[rowEnd][i]);
                j++;
            }                       
            rowEnd -= 1;            
            for(int i = rowEnd;i >= rowBegin&j<rows * cols;i--){
                result.add(matrix[i][colBegin]);
                j++;
            }                       
            colBegin += 1;          
        }                           
        return result;              
    }
}
