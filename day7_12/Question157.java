/* The read4 API is defined in the parent class Reader4.
 *       int read4(char[] buf); */
class Reader4{
    public int read4(char[] buf){
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
            eof = count < 4;
            count = Math.min(count, n - total);
            for (int i = 0; i < count; i++) 
                buf[total++] = tmp[i];
        }
        return total;
    }
}
