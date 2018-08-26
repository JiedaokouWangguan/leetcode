import java.lang.System;
import java.util.Arrays;

public class Question828{
    public int uniqueLetterString(String S) {
        int[][] record = new int[26][2];
        char[] chars = S.toCharArray();
        int result = 0;
        for(int i = 0;i<26;i++) record[i] = new int[]{-1, -1};
        for(int i = 0;i<chars.length;i++){
            int index = chars[i] - 'A';
            result += (record[index][1] - record[index][0]) * (i - record[index][1]);
            record[index][0] = record[index][1];
            record[index][1] = i;
        }
        for(int i = 0;i<26;i++){
            result += (record[i][1] - record[i][0]) * (chars.length - record[i][1]);
        }
        return result;
    }
}