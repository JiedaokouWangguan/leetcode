public class QuestionToss100{
    private double getExpectation(int max){
        double[][] dp = new double[max+1][max+1];
        for(int head = 0;head<=max;head++){
            int tail = max - head;
            dp[head][tail] = 1.0 * head / (head + tail);
        }
        for(int head = max;head >=0;head--){
            for(int tail = max - 1 - head;tail>=0;tail--){
                if(head + tail == 0){
                    dp[head][tail] = 0.5 * dp[head+1][tail] + 0.5 * dp[head][tail+1];
                }
                else{
                    dp[head][tail] = Math.max(head * 1.0 / (head + tail), (0.5 * dp[head+1][tail]+ 0.5 * dp[head][tail+1]));
                }
            }
        }
        return dp[0][0];
    }
}
