public class Question389{
    public char findTheDifference(String s, String t) {
        char result = 0;
        for(int i = 0;i<s.length();i++)
        {
            char c = s.charAt(i);
            result ^= c;
        }
        for(int i = 0;i<t.length();i++)
        {
            char c = t.charAt(i);
            result ^= (int)c;
        }
        return result;
    }
}
