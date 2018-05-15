package leetcode.day5_13;

import java.util.HashSet;

/**
 * Created by Song on 2018/5/13.
 */
public class Question804
{
    public int uniqueMorseRepresentations(String[] words)
    {
        String[] morse = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        HashSet<String> set = new HashSet<>();
        StringBuilder sb;
        for (String s : words)
        {
            sb = new StringBuilder();
            for (int i = 0;i<s.length();i++)
            {
                sb.append(morse[s.charAt(i) - 'a']);
            }
            set.add(sb.toString());
        }
        return set.size();
    }
}
