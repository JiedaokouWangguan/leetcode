public class Question906{
    public int superpalindromesInRange(String L, String R) {
        long l = Long.parseLong(L);
        long r = Long.parseLong(R);
        int result = 0;
        long root = (long)Math.sqrt(l);
        while(root*root <= r){
            if(root*root >= l && isP(root) && isP(root*root)) result += 1;
            root = nextP(root);
            if(root * root <= r && isP(root*root))
                result += 1;
            root += 1;
        }
        return result;
    }

    private long nextP(long i){
        String s = String.valueOf(i);
        int r = s.length()/2;
        int l = s.length() - r;
        String lStr = s.substring(0, l);
        long leftNum = Long.parseLong(lStr)+1;
        StringBuilder sb = new StringBuilder(lStr);
        String tmp = lStr + sb.reverse().substring(sb.length()-r).toString();
        long can1 = Long.parseLong(tmp);

        sb = new StringBuilder(""+leftNum);
        tmp = ""+leftNum + sb.reverse().substring(sb.length()-r).toString();
        long can2 = Long.parseLong(tmp);

        if(i >= can1) return can2;
        else return can1;
    }

    private boolean isP(long i){
        String s = String.valueOf(i);
        int l = 0;
        int r = s.length()-1;
        while(l < r){
            if(s.charAt(l++) != s.charAt(r--)) return false;
        }
        return true;
    }
}
