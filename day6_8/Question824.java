import java.util.Scanner;

public class Question824{
    public String toGoatLatin(String S){
        Scanner s = new Scanner(S);
        StringBuilder sb = new StringBuilder();
        int index = 1;
        while(s.hasNext()){
            sb.append(convert(s.next(), index++));
            sb.append(" ");
        }
        String result = sb.toString();
        return result.substring(0, result.length()-1);
    }

    private String convert(String s, int index){
        char c = s.charAt(0);
        if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' || c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U'){
            s = s + "ma";
        }
        else{
            s = s.substring(1, s.length()) + c + "ma";
        }
        for(int i = 0;i<index; i++)
            s += "a";
        return s;
    }
}
