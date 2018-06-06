import java.util.Arrays;

public class Question781{
    public int numRabbits(int[] answers){
        Arrays.sort(answers);
        if(answers.length == 1)
            return 1+answers[0];
        int result = 0;
        int count = 1;
        int i = 1;
        for(;i<answers.length;i++){
            if(answers[i] == answers[i-1]){ 
                count += 1;
            }
            else{
                if(count <= answers[i-1]+1)
                    result += answers[i-1] + 1;
                else{
                    int tmp = (int)Math.ceil(count*1.0 / (answers[i-1]+1));
                    result += tmp * (answers[i-1] + 1);
                }
                count = 1;
            }
        }
        if(count <= answers[i-1]+1)
            result += answers[i-1] + 1;
        else{
            int tmp = (int)Math.ceil(count * 1.0 / (answers[i-1]+1));
            result += tmp * (answers[i-1] + 1);
        }
        return result;
    }
}
