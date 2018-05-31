public class Question521{
    public int findLUSlength(String a, String b){
        if(a.equals(b))
            return -1;
        if(a.length() > b.length())
            return a.length();
        else
            return b.length();
    }
}
