public class Question551{
    public boolean checkRecord(String s){
        char[] record = s.toCharArray();
        int absentCount = 0;
        int lateCount = 0;
        for(char c : record){
            if(c == 'A'){
                if(absentCount == 1)
                    return false;
                else
                    absentCount += 1;
                lateCount = 0;
            }
            else if(c == 'L'){
                if(lateCount == 2)
                    return false;
                else
                    lateCount += 1;
            }
            else
                lateCount = 0;
        }
        return true;
    }
}
