public class Question564{
    public String nearestPalindromic(String n) {
        char[] chars = n.toCharArray();
        for (int i = 0; i < n.length() / 2; i++)
            chars[n.length() - i - 1] = chars[i];

        String cur = String.valueOf(chars);
        String prev = getNear(n, true);
        String next = getNear(n, false);

        long ori = Long.parseLong(n);
        long curNum = Long.parseLong(cur);
        long prevNum = Long.parseLong(prev);
        long nextNum = Long.parseLong(next);

        long diff1 = Math.abs(ori - prevNum);
        long diff2 = Math.abs(ori - curNum);
        long diff3 = Math.abs(ori - nextNum);

        if (ori == curNum) return diff1 <= diff3 ? prev : next;
        else if (ori > curNum) return diff2 <= diff3 ? cur : next;
        else return diff1 <= diff2 ? prev : cur;
    }

    private String getNear(String s, boolean less) {
        int k = s.length() / 2;
        int l = s.length() - k;
        String left = s.substring(0, l);
        int numLeft = Integer.parseInt(left);
        numLeft = less ? numLeft - 1 : numLeft + 1;
        if (numLeft == 0) return k == 0 ? "0" : "9"; //s是十几或者几

        StringBuilder leftSB = new StringBuilder(String.valueOf(numLeft));
        StringBuilder rightSB = new StringBuilder(leftSB).reverse();
        if (k > leftSB.length()) rightSB.append(leftSB.toString().charAt(0)); //左边右边长度一样但左边减1后少了一位，右边如果也少一位加起来就少了两位

        return leftSB.append(rightSB.substring(rightSB.length() - k)).toString(); //左边加了一位多了一位，导致右边比原来多了，所以去子字符串
    }
}
