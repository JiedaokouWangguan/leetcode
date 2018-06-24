import java.util.Arrays;

public class Question135{
    public int candy(int[] ratings) {
        int[] result1 = new int[ratings.length];
        int[] result2 = new int[ratings.length];
        Arrays.fill(result1, 1);
        Arrays.fill(result2, 1);

        for(int i = 1;i<ratings.length;i++){
            if(ratings[i] > ratings[i-1]){
                result1[i] = result1[i-1] + 1;
            }
        }
        for(int i = ratings.length-2;i>=0;i--){
            if(ratings[i] > ratings[i+1]){
                result2[i] = result2[i+1] + 1;
            }
        }
        int result = 0;
        for(int i = 0;i<ratings.length;i++){
            result += Math.max(result1[i], result2[i]);
        }
        return result;
    }
}
