public class Question788{
    public int rotatedDigits(int N){
        int count = 0;
        for(int i = 0;i<= N;i++){
            if(isValid(i)) count ++;
        }
        return count;
    }

    public boolean isValid(int N){
        boolean validFound = false;
        while(N > 0){
            int tmp = N % 10;
            if(tmp == 2 || tmp == 5 || tmp == 6 || tmp == 9)
                validFound = true;
            else if(tmp == 3 || tmp == 4 || tmp == 7)
                return false;
            N = N / 10;
        }
        return validFound;
    }
}
