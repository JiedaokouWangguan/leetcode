public class Question564{
    public String nearestPalindromic(String n) {
        long origi = Long.parseLong(n);

        long p = getP(n);
        long pb = getPB(n);
        long ps = getPS(n);

        if(p == origi){
            if(pb - p < p - ps) return pb+"";
            else return ps+"";
        }
        else if(p > origi){
            if(p - origi < origi - ps) return p+"";
            else return ps+"";
        }
        else{
            if(pb - origi < origi - p) return pb+"";
            else return p +"";
        }
    }

    private long getP(String s){
        int r = s.length()/2;
        int l = s.length()-r;

        String left = s.substring(0, l);
        StringBuilder sb = new StringBuilder(left);
        String right = sb.reverse().substring(sb.length()-r).toString();
        return Long.parseLong(left+right);
    }

    private long getPB(String s){
        int r = s.length()/2;
        int l = s.length()-r;

        String left = Integer.parseInt(s.substring(0, l))+1+"";

        StringBuilder sb = new StringBuilder(left);
        String right = sb.reverse().substring(sb.length()-r).toString();
        return Long.parseLong(left+right);

    }

    private long getPS(String s){
        int r = s.length()/2;
        int l = s.length()-r;

        String left = Integer.parseInt(s.substring(0, l))-1+"";
        if(left.equals("0")) return r == 0?0:9;
        StringBuilder sb = new StringBuilder(left);

        String right = sb.reverse().toString();
        if(left.length() < r) right += "9";
        right = right.substring(right.length()-r);
        String res = left + right;

        return Long.parseLong(res);
    }   
}
