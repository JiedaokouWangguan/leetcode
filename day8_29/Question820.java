package leetcode.day8_29;

import java.util.HashSet;

public class Question820 {
    public int minimumLengthEncoding(String[] words) {
        HashSet<String> set = new HashSet<>();
        for(String str : words) set.add(str);
        for (String word : words){
            for (int i = 1;i<word.length();i++){
                String str = word.substring(i);
                set.remove(str);
            }
        }
        int result = 0;
        for(String str : set) result += str.length() + 1;
        return result;
    }
}
