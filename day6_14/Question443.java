public class Question443{
    public int compress(char[] chars){
        int index = 0;
        char pre = chars[0];
        int count = 1;
        for(int i = 1;i<chars.length;i++){
            if(chars[i] == pre){
                count += 1;
            }
            else{
                chars[index++] = pre;
                if(count > 1){
                    String tmp = "";
                    while(count > 0){
                        tmp = count % 10 + tmp;
                        count /= 10;
                    }
                    for(int j = 0;j<tmp.length();j++){
                        chars[index++] = tmp.charAt(j);
                    }
                }
                pre = chars[i];
                count = 1;
            }
        }
        chars[index++] = pre;
        if(count > 1){
            String tmp = "";
            while(count > 0){
                tmp =count % 10 + tmp;
                count /= 10;
            }
            for(int i = 0;i<tmp.length();i++){
                chars[index++] = tmp.charAt(i);
            }
        }
        return index;
    }
}
