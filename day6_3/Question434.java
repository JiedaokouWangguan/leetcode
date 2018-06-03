import java.util.Scanner;

public class Question434{
    public int countSegments(String s){
        int result = 0;
        char[] chars = s.toCharArray();
        for(int i = 0;i<chars.length;i++){
            if(chars[i] != ' ' && (i != 0 || chars[i-1] == ' '))
                result += 1;
        }
        return result;
    }

    public int countSegments1(String s){
        Scanner scanner = new Scanner(s);
        int result = 0;
        while(scanner.hasNext()){
            scanner.next();
            result += 1;
        }
        return result;
    }
}
