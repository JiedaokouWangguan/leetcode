class Reader4{
    int read4(char[] buf){
        return 0;
    }
}

class Solution extends Reader4 {
    /**
     *      * @param buf Destination buffer
     *           * @param n   Maximum number of characters to read
     *                * @return    The number of characters read
     *                     */
    public int read(char[] buf, int n) {
        boolean eof = false;      // end of file flag
        int total = 0;            // total bytes have read
        char[] tmp = new char[4]; // temp buffer

        while (!eof && total < n) {
            int count = read4(tmp);

            // check if it's the end of the file
            eof = count < 4;

            // get the actual count
            count = Math.min(count, n - total);

            // copy from temp buffer to buf
            for (int i = 0; i < count; i++) 
                buf[total++] = tmp[i];
        }

        return total;
    }
}
