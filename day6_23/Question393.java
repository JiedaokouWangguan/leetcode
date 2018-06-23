public class Question393{
    public boolean validUtf8(int[] data) {
        int idx = 0;
        while (idx < data.length) {
            int followers = count (data [idx ++]) - 1;
            if (followers == 0 || followers >= 4) return false;
            while (followers -- > 0) if (idx == data.length || count (data [idx ++]) != 1) return false;
        }
        return true;
    }

    private int count (int num) {
        int bits = 0;
        for (int idx = 7; idx >= 0; idx --) if ((num >> idx & 1) == 0) break; else bits ++;
        return bits;
    }
}
