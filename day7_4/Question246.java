public class Question246{
    public boolean isStrobogrammatic(String num) {
        if(num == null || num.length() == 0)
            return false;
        char[] chars = num.toCharArray();
        for(int i = 0;i<chars.length;i++){
            if(i != '0' && i != '1' && i != '6' && i != '8' && i != '9')
                return false;
            if(i == '0' || i == '1' || i == '8')
                continue;
            else{
                if(i >= chars.length/2)
                    continue;
                if(i == '6'){
                    if(chars[chars.length-1-i] == '9')
                        continue;
                    else
                        return false;
                }
                else{
                    if(chars[chars.length-1-i] == '6')
                        continue;
                    else
                        return false;
                }
            }
        }
        return true;
    }
}
