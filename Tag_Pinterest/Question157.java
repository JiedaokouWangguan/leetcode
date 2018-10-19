public class Question157{
    public int read(char[] buf, int n) {
        int index = 0;

        char[] cur = new char[4];
        boolean eof = false;
        while(!eof && index < n){
            int res = read4(cur);
            if(res < 4) eof = true;
            int count = Math.min(res, n - index);
            for(int i = 0;i<count;i++)
                buf[index++] = cur[i];
        }
        return index;
    }

    int read4(char[] buf){
        return 0;
    }
}
