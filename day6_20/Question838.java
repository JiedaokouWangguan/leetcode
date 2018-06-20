import java.util.Arrays;

public class Question838{
    public String pushDominoes(String dominoes) {
        dominoes = "L" + dominoes + "R";
        char[] chars = dominoes.toCharArray();
        int lastIndex = -2;
        boolean hasR = false;
        for(int i = 0;i<chars.length;i++){
            if(chars[i] == 'L'){
                if(lastIndex == -2)
                    continue;
                else if(!hasR){
                    Arrays.fill(chars, lastIndex, i, 'L');
                }
                else{
                    int end = i-1;
                    int begin = lastIndex;
                    if((end-begin)%2 == 1){
                        Arrays.fill(chars, begin, (begin + end)/2+1, 'R');
                        Arrays.fill(chars, (begin+end)/2+1, end+1, 'L');
                    }
                    else{
                        Arrays.fill(chars, begin, (begin+end)/2, 'R');
                        Arrays.fill(chars, (begin+end)/2+1, end+1, 'L');
                    }
                }
                hasR = false;
                lastIndex = -2;
            }
            else if(chars[i] == 'R'){
                if(lastIndex == -2)
                    continue;
                if(hasR)
                    Arrays.fill(chars, lastIndex, i, 'R');
                lastIndex = -2;
                hasR = true;
            }
            else{
                if(lastIndex == -2)
                    lastIndex = i;
            }
        }
        StringBuilder sb = new StringBuilder(chars.length);
        for(char c : chars){
            sb.append(c);
        }
        return sb.toString();
    }
}
