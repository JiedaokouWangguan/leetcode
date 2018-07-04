public class Question408{
    public boolean validWordAbbreviation(String word, String abbr) {
        int num = 0;
        char[] wordChars = word.toCharArray();
        char[] abbrChars = abbr.toCharArray();
        int index = 0;
        for(int i = 0;i<abbrChars.length;i++){
            if(abbrChars[i] >= '0' && abbrChars[i] <= '9'){
                if(num == 0 && abbrChars[i] == '0')
                    return false;
                num = num * 10 + (abbrChars[i] - '0');
            }
            else{
                index += num;
                num = 0;
                if(index >= wordChars.length)
                    return false;
                if(abbrChars[i] != wordChars[index])
                    return false;
                index += 1;
            }
        }
        return num == wordChars.length - index;
    }
}
