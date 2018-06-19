public class Question392{
    public boolean isSubsequence(String s, String t) {
        int indexS = 0;
        char[] charS = s.toCharArray();
        char[] charT = t.toCharArray();
        for(int i = 0;i<charT.length && indexS < charS.length;i++){
            if(charT[i] == charS[indexS])
                indexS += 1;
        }
        return indexS == charS.length;
    }
}
