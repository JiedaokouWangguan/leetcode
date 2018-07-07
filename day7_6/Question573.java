import java.util.ArrayList;

public class Question573{
    public int minDistance(int height, int width, int[] tree, int[] squirrel, int[][] nuts) {
        int result = 0;
        int minDist = Integer.MAX_VALUE;
        int minIndex = 0;

        for(int i = 0;i<nuts.length;i++){
            int[] position = nuts[i];
            result += 2 * getDist(tree, position);
        }
        int tmpResult = result - getDist(tree, nuts[0]) + getDist(squirrel, nuts[0]);
        for(int i = 1;i<nuts.length;i++){
            int tmp = result - getDist(tree, nuts[i]) + getDist(squirrel, nuts[i]);
            if(tmp < tmpResult) tmpResult = tmp;
        }
        return tmpResult;                                                                                                                                                                                      
    }       

    private int getDist(int[] p1, int[] p2){
        return Math.abs(p1[0] - p2[0]) + Math.abs(p1[1] - p2[1]);
    }
}

