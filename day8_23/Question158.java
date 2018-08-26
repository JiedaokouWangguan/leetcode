public class Solution extends Reader4 {
	/**
	 * @param buf Destination buffer
	 * @param n   Maximum number of characters to read
	 * @return    The number of characters read
	 */



	int i4 = 0;
	int n4 = 0;
	char[] buff4 = new char[4];
	public int read(char[] buf, int n) {
		int i = 0;
		while(i < n && (i4 < n4 || (i4 = 0) < (n4 = read4(buff4))))
			buf[i++] = buff4[i4++];
		return i;
	}

}
