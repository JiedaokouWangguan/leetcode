public class Question796{
    public boolean rotateString(String A, String B){
        if(A.length() != B.length())
            return false;
        String AA = A + A;
        return AA.indexOf(B) != -1;
    }
}
